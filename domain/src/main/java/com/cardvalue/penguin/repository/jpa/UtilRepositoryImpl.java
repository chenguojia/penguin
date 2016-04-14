package com.cardvalue.penguin.repository.jpa;

import com.cardvalue.penguin.dto.LabelValueTO;
import com.cardvalue.penguin.model.CvRegionConf;
import com.cardvalue.penguin.model.StartupImage;
import com.cardvalue.penguin.model.UserStartupImage;
import com.cardvalue.penguin.model.WeUser;
import com.cardvalue.penguin.repository.UtilRepository;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guojia.chen on 2015-12-30 15:41.
 *
 * @Description:
 */
@Repository("utilRepo")
@Transactional(readOnly=true)
public class UtilRepositoryImpl implements UtilRepository {

    private final static Logger logger = LoggerFactory.getLogger(UtilRepositoryImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public String getBranchLabelByCode(String code){
        Query findBranchLabelByCodeQuery = em.createNamedQuery("findBranchLabelByCode").setParameter("code", code);
        String name = "";
        try {
            name = (String)findBranchLabelByCodeQuery.getSingleResult();
        } catch (NoResultException e) {
            logger.warn(e.getMessage());
        }
        return name;
    }

    @Override
    public String getRegionLabelByCode(String code){
        Query findBranchLabelByCodeQuery = em.createNamedQuery("findRegionLabelByCode").setParameter("code", code);
        String name = "";
        try {
            name = (String)findBranchLabelByCodeQuery.getSingleResult();
        } catch (NoResultException e) {
            logger.warn(e.getMessage());
        }
        return name;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<String> getStartupImages(int userId){
        List<String> imageList = new ArrayList<String>();
        List<Object[]> imgs = (List<Object[]>)em.createNamedQuery("findAvailStartupImage").getResultList();
        for(Object[] img : imgs){
            int id = (Integer)img[0];
            String imageUrl = (String)img[1];
            Query q = em.createNamedQuery("findUserStartupImageCount")
                    .setParameter("userId", userId)
                    .setParameter("imageId", id);
            int count = ((BigInteger)q.getSingleResult()).intValue();
            if(count == 0){
                UserStartupImage userImage = new UserStartupImage();
                userImage.setStartupImage(em.find(StartupImage.class, id));
                userImage.setUser(em.find(WeUser.class, userId));
                em.persist(userImage);
                imageList.add(imageUrl);
            }
        }
        return imageList;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly=true)
    public List<LabelValueTO> getAllBranches(){
        Query query = em.createNativeQuery("select code, label from master_branch");
        List<Object[]> list = query.getResultList();
        List<LabelValueTO> branchList = new ArrayList<LabelValueTO>();
        for(Object[] strs : list){
            //跳过总公司
            if(StringUtils.equals((String) strs[0], "0001")){
                continue;
            }
            LabelValueTO lv = new LabelValueTO();
            lv.setLabel((String)strs[1] + "-" + (String)strs[0]);
            lv.setValue((String)strs[0]);
            branchList.add(lv);
        }
        return branchList;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly=true)
    public List<LabelValueTO> getRegionsByBranch(String branchCode){
        Query query = em.createNativeQuery("select mr.code, mr.label from master_region mr left join branch_region br on mr.code=br.region_code"
                + " where br.branch_code=:branchCode");
        List<Object[]> list = query.setParameter("branchCode", branchCode).getResultList();
        List<LabelValueTO> regionList = new ArrayList<LabelValueTO>();
        if(list.size() > 1){
            LabelValueTO lv = new LabelValueTO();
            lv.setLabel("所有地市");
            lv.setValue("all");
            regionList.add(lv);
        }
        for(Object[] strs : list){
            LabelValueTO lv = new LabelValueTO();
            lv.setLabel((String)strs[1] + "-" + (String)strs[0]);
            lv.setValue((String)strs[0]);
            regionList.add(lv);
        }
        return regionList;
    }

    @Override
    @Transactional(readOnly=true)
    public String getBranchCodeByRegionCode(String regionCode, String salesBranchCode){
        Query query = em.createNativeQuery("select distinct branch_code from branch_region where region_code=:regionCode");
        String branchCode = salesBranchCode;
        try{
            branchCode = (String)query.setParameter("regionCode", regionCode).getSingleResult();
        }catch(NoResultException e){
            logger.warn("",e);
        }catch(NonUniqueResultException e){
            logger.warn("",e);
        }
        return branchCode;
    }

    @Override
    @Transactional(readOnly=true)
    public String getProvinceCodeByRegionCode(String regionCode){
        Query query = em.createNativeQuery("select distinct province_code from branch_region where region_code=:regionCode");
        String provinceCode = null;
        try{
            provinceCode = (String)query.setParameter("regionCode", regionCode).getSingleResult();
        }catch(NoResultException e){
            logger.warn("",e);
        }catch(NonUniqueResultException e){
            logger.warn("",e);
        }
        return provinceCode;
    }

    @Override
    public void resetSequenceNumber(){
        Query resetQuery = em.createNativeQuery("update tb_sequence set current_value=1 where type=1");
        resetQuery.executeUpdate();
    }


    /**
     * 查询所有省份或者城市
     * @param type 1省  2市
     * @param pid 上一节点id
     * @return
     */
    @Override
    public List<CvRegionConf> queryProvincesOrRegions(Integer type,Integer pid){

        //查询省份或者城市的SQL
        String hql = "SELECT t FROM CvRegionConf t WHERE t.regionLevel=:regionLevel";

        TypedQuery<CvRegionConf> query = null;

        if(type == 1){
            //查询省份
            query = em.createQuery(hql, CvRegionConf.class).setParameter("regionLevel", 2);
        }else if(type == 2){
            //查询市
            hql += " AND t.pid=:pid";
            query = em.createQuery(hql, CvRegionConf.class).setParameter("regionLevel", 3).setParameter("pid", pid);
        }

        List<CvRegionConf> list = query.getResultList();

        return list;
    }

    /**
     * 通过省份或者城市id获取对象
     * @param id
     * @return
     */
    public CvRegionConf getProvincesOrRegionsById(Integer id){
        TypedQuery<CvRegionConf> query = em.createQuery("SELECT t FROM CvRegionConf t WHERE t.id=:id", CvRegionConf.class).setParameter("id", id);
        CvRegionConf cvRegionConf = query.getSingleResult();
        return cvRegionConf;
    }

    @Override
    public CvRegionConf getProvincesOrRegionsByName(String name){
        TypedQuery<CvRegionConf> query = em.createQuery("SELECT t FROM CvRegionConf t WHERE t.name like :name", CvRegionConf.class).setParameter("name", "%" + name + "%");
        CvRegionConf cvRegionConf = query.getSingleResult();
        return cvRegionConf;
    }

    @Override
    public String getCategoryByMcc(String mcc){
        Query query = em.createNativeQuery("SELECT category FROM conf_mcc WHERE mcc=:mcc").setParameter("mcc", mcc);
        String category = null;
        try{
            category = (String)query.getSingleResult();
        }catch(NoResultException e){
            logger.info("Cannot find mcc code:" + mcc);
        }
        return category;
    }

    /**
     * 通过mcc查询mcc整条记录对象
     * @param mcc
     * @return
     */
    @Override
    public Object[] getCategoryAndFlagByMcc(String mcc) {
        Query query = em.createNativeQuery("SELECT category,flag FROM conf_mcc WHERE mcc=:mcc").setParameter("mcc", mcc);
        Object [] array = null;
        try{
            array = (Object[])  query.getSingleResult();
        }catch(NoResultException e){
            logger.info("Cannot find mcc code:" + mcc);
        }
        return array;
    }

    /**
     * 根据银联分支机构来查询系统中标准的省市
     * @param name
     * @return
     */
    public CvRegionConf getProvincesOrRegionsByMatching(String name){
        TypedQuery<CvRegionConf> query = em.createQuery("FROM CvRegionConf t WHERE t.name LIKE :name AND (t.regionLevel = 2 OR t.regionLevel = 3) ORDER BY t.regionLevel", CvRegionConf.class).setParameter("name", name);
        List<CvRegionConf> cvRegionConfs = query.getResultList();
        if (cvRegionConfs != null && cvRegionConfs.size() > 0) {
            //如果查询到了省和市多条记录，优先返回市
            int regionIndex = 0;
            for (int i= 0;i < cvRegionConfs.size();i++){
                if(cvRegionConfs.get(i).getRegionLevel() == 3) {
                    //表示查市级别
                    regionIndex = i;
                }
            }
            return cvRegionConfs.get(regionIndex);
        } else {
            return null;
        }
    }
}


