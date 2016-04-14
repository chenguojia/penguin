package com.cardvalue.penguin.dto;


import com.cardvalue.penguin.util.Constants;

public class TextMessage extends BaseMessage {

	private Text text;
	
	public TextMessage(){
		this.setMsgtype(Constants.WE_MESSAGE_TYPE_TEXT);
		this.setText(new Text());
	}
	
	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public class Text {
		private String content;

		public Text(){}
		
		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
	}
}
