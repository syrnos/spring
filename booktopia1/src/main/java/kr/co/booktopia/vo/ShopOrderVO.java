package kr.co.booktopia.vo;

import org.springframework.stereotype.Component;

@Component
public class ShopOrderVO {

	private int ORDER_SEQ_NUM;
	private int ORDER_ID;
	private String MEMBER_ID;
	private int GOODS_ID;
	private String ORDERER_NAME;
	private String GOODS_TITLE;
	private int ORDER_GOODS_QTY;
	private int GOODS_SALES_PRICE;
	private String GOODS_FILENAME;
	private String RECEIVER_NAME;
	private String RECEIVER_HP1;
	private String RECEIVER_HP2;
	private String RECEIVER_HP3;
	private String RECEIVER_TEL1;
	private String RECEIVER_TEL2;
	private String RECEIVER_TEL3;
	private String DELIVERY_ADDRESS;
	private String DELIVERY_METHOD;
	private String DELIVERY_MESSAGE;
	private String GIFT_WRAPPING;
	private String PAY_METHOD;
	private String CARD_COM_NAME;
	private String CARD_PAY_MONTH;
	private String PAY_ORDERER_HP_NUM;
	private String DELIVERY_STATE;
	private String PAY_ORDER_TIME;
	private String ORDERER_HP;
	
	
	
	
	
	public int getORDER_SEQ_NUM() {
		return ORDER_SEQ_NUM;
	}
	public void setORDER_SEQ_NUM(int oRDER_SEQ_NUM) {
		ORDER_SEQ_NUM = oRDER_SEQ_NUM;
	}
	public int getORDER_ID() {
		return ORDER_ID;
	}
	public void setORDER_ID(int oRDER_ID) {
		ORDER_ID = oRDER_ID;
	}
	public String getMEMBER_ID() {
		return MEMBER_ID;
	}
	public void setMEMBER_ID(String mEMBER_ID) {
		MEMBER_ID = mEMBER_ID;
	}
	public int getGOODS_ID() {
		return GOODS_ID;
	}
	public void setGOODS_ID(int gOODS_ID) {
		GOODS_ID = gOODS_ID;
	}
	public String getORDERER_NAME() {
		return ORDERER_NAME;
	}
	public void setORDERER_NAME(String oRDERER_NAME) {
		ORDERER_NAME = oRDERER_NAME;
	}
	public String getGOODS_TITLE() {
		return GOODS_TITLE;
	}
	public void setGOODS_TITLE(String gOODS_TITLE) {
		GOODS_TITLE = gOODS_TITLE;
	}
	public int getORDER_GOODS_QTY() {
		return ORDER_GOODS_QTY;
	}
	public void setORDER_GOODS_QTY(int oRDER_GOODS_QTY) {
		ORDER_GOODS_QTY = oRDER_GOODS_QTY;
	}
	public int getGOODS_SALES_PRICE() {
		return GOODS_SALES_PRICE;
	}
	public void setGOODS_SALES_PRICE(int gOODS_SALES_PRICE) {
		GOODS_SALES_PRICE = gOODS_SALES_PRICE;
	}
	public String getGOODS_FILENAME() {
		return GOODS_FILENAME;
	}
	public void setGOODS_FILENAME(String gOODS_FILENAME) {
		GOODS_FILENAME = gOODS_FILENAME;
	}
	public String getRECEIVER_NAME() {
		return RECEIVER_NAME;
	}
	public void setRECEIVER_NAME(String rECEIVER_NAME) {
		RECEIVER_NAME = rECEIVER_NAME;
	}
	public String getRECEIVER_HP1() {
		return RECEIVER_HP1;
	}
	public void setRECEIVER_HP1(String rECEIVER_HP1) {
		RECEIVER_HP1 = rECEIVER_HP1;
	}
	public String getRECEIVER_HP2() {
		return RECEIVER_HP2;
	}
	public void setRECEIVER_HP2(String rECEIVER_HP2) {
		RECEIVER_HP2 = rECEIVER_HP2;
	}
	public String getRECEIVER_HP3() {
		return RECEIVER_HP3;
	}
	public void setRECEIVER_HP3(String rECEIVER_HP3) {
		RECEIVER_HP3 = rECEIVER_HP3;
	}
	public String getRECEIVER_TEL1() {
		return RECEIVER_TEL1;
	}
	public void setRECEIVER_TEL1(String rECEIVER_TEL1) {
		RECEIVER_TEL1 = rECEIVER_TEL1;
	}
	public String getRECEIVER_TEL2() {
		return RECEIVER_TEL2;
	}
	public void setRECEIVER_TEL2(String rECEIVER_TEL2) {
		RECEIVER_TEL2 = rECEIVER_TEL2;
	}
	public String getRECEIVER_TEL3() {
		return RECEIVER_TEL3;
	}
	public void setRECEIVER_TEL3(String rECEIVER_TEL3) {
		RECEIVER_TEL3 = rECEIVER_TEL3;
	}
	public String getDELIVERY_ADDRESS() {
		return DELIVERY_ADDRESS;
	}
	public void setDELIVERY_ADDRESS(String dELIVERY_ADDRESS) {
		DELIVERY_ADDRESS = dELIVERY_ADDRESS;
	}
	public String getDELIVERY_METHOD() {
		return DELIVERY_METHOD;
	}
	public void setDELIVERY_METHOD(String dELIVERY_METHOD) {
		DELIVERY_METHOD = dELIVERY_METHOD;
	}
	public String getDELIVERY_MESSAGE() {
		return DELIVERY_MESSAGE;
	}
	public void setDELIVERY_MESSAGE(String dELIVERY_MESSAGE) {
		DELIVERY_MESSAGE = dELIVERY_MESSAGE;
	}
	public String getGIFT_WRAPPING() {
		return GIFT_WRAPPING;
	}
	public void setGIFT_WRAPPING(String gIFT_WRAPPING) {
		GIFT_WRAPPING = gIFT_WRAPPING;
	}
	public String getPAY_METHOD() {
		return PAY_METHOD;
	}
	public void setPAY_METHOD(String pAY_METHOD) {
		PAY_METHOD = pAY_METHOD;
	}
	public String getCARD_COM_NAME() {
		return CARD_COM_NAME;
	}
	public void setCARD_COM_NAME(String cARD_COM_NAME) {
		CARD_COM_NAME = cARD_COM_NAME;
	}
	public String getCARD_PAY_MONTH() {
		return CARD_PAY_MONTH;
	}
	public void setCARD_PAY_MONTH(String cARD_PAY_MONTH) {
		CARD_PAY_MONTH = cARD_PAY_MONTH;
	}
	public String getPAY_ORDERER_HP_NUM() {
		return PAY_ORDERER_HP_NUM;
	}
	public void setPAY_ORDERER_HP_NUM(String pAY_ORDERER_HP_NUM) {
		PAY_ORDERER_HP_NUM = pAY_ORDERER_HP_NUM;
	}
	public String getDELIVERY_STATE() {
		return DELIVERY_STATE;
	}
	public void setDELIVERY_STATE(String dELIVERY_STATE) {
		DELIVERY_STATE = dELIVERY_STATE;
	}
	public String getPAY_ORDER_TIME() {
		return PAY_ORDER_TIME;
	}
	public void setPAY_ORDER_TIME(String pAY_ORDER_TIME) {
		PAY_ORDER_TIME = pAY_ORDER_TIME;
	}
	public String getORDERER_HP() {
		return ORDERER_HP;
	}
	public void setORDERER_HP(String oRDERER_HP) {
		ORDERER_HP = oRDERER_HP;
	}
	
	
	
}