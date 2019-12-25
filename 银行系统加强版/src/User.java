public class User {
	
     private String call;
     private int account;
     private String userName;
     private String cardPwd;
     private String cardId;
     
     
     public String getCall(){
		return call; 
     }
     public void setCall(String call){
    	 this.call=call;
     }
     public int getAccount(){
		return account;
     }
     public void setAmount(int account){
    	 this.account=account;
     }
     public String getUserName(){
		return userName;
     }
     public void setUseName(String userName){
    	 this.userName=userName;
     }
     public String getCardPwd(){
		return cardPwd;
     }
     public void setCardPwd(String cardPwd){
    	 this.cardPwd=cardPwd;
     }
     public String getCardId(){
		return cardId;
     }
     public void setCardId(String cardId){
    	 this.cardId=cardId;
     }
}