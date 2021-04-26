
package entity;
// AGQPGameRecord
public class AGQPGameRecord{
    public AGQPGameRecord() {

    }
    
    //
    private Integer Id;
        
    //
    private String CompanyStyle;
        
    //
    private String Account;
        
    //
    private String GameName;
        
    //
    private String ServerName;
        
    //
    private Double BetAmount;
        
    //
    private Double Score;
        
    //
    private Double Revenue;
        
    //
    private Integer PlayerId;
        
    //
    private Integer ServerId;
        
    //
    private Integer GameId;
        
    //
    private java.util.Date StartTime;
        
    //
    private java.util.Date EndTime;
        
    //
    private String GameCode;
        
    //
    private java.util.Date CreateTime;
        
    //
    private bit IsDelete;
        
    public Integer getId() {
        return Id;
    }
    public void setId(Integer Id) {
        this.Id = Id;
    }
            
    public String getCompanyStyle() {
        return CompanyStyle;
    }
    public void setCompanyStyle(String CompanyStyle) {
        this.CompanyStyle = CompanyStyle;
    }
            
    public String getAccount() {
        return Account;
    }
    public void setAccount(String Account) {
        this.Account = Account;
    }
            
    public String getGameName() {
        return GameName;
    }
    public void setGameName(String GameName) {
        this.GameName = GameName;
    }
            
    public String getServerName() {
        return ServerName;
    }
    public void setServerName(String ServerName) {
        this.ServerName = ServerName;
    }
            
    public Double getBetAmount() {
        return BetAmount;
    }
    public void setBetAmount(Double BetAmount) {
        this.BetAmount = BetAmount;
    }
            
    public Double getScore() {
        return Score;
    }
    public void setScore(Double Score) {
        this.Score = Score;
    }
            
    public Double getRevenue() {
        return Revenue;
    }
    public void setRevenue(Double Revenue) {
        this.Revenue = Revenue;
    }
            
    public Integer getPlayerId() {
        return PlayerId;
    }
    public void setPlayerId(Integer PlayerId) {
        this.PlayerId = PlayerId;
    }
            
    public Integer getServerId() {
        return ServerId;
    }
    public void setServerId(Integer ServerId) {
        this.ServerId = ServerId;
    }
            
    public Integer getGameId() {
        return GameId;
    }
    public void setGameId(Integer GameId) {
        this.GameId = GameId;
    }
            
    public java.util.Date getStartTime() {
        return StartTime;
    }
    public void setStartTime(java.util.Date StartTime) {
        this.StartTime = StartTime;
    }
            
    public java.util.Date getEndTime() {
        return EndTime;
    }
    public void setEndTime(java.util.Date EndTime) {
        this.EndTime = EndTime;
    }
            
    public String getGameCode() {
        return GameCode;
    }
    public void setGameCode(String GameCode) {
        this.GameCode = GameCode;
    }
            
    public java.util.Date getCreateTime() {
        return CreateTime;
    }
    public void setCreateTime(java.util.Date CreateTime) {
        this.CreateTime = CreateTime;
    }
            
    public bit getIsDelete() {
        return IsDelete;
    }
    public void setIsDelete(bit IsDelete) {
        this.IsDelete = IsDelete;
    }
             
    @Override
    public String toString() {
        return "AGQPGameRecord[Id=" + Id + ",CompanyStyle=" + CompanyStyle + ",Account=" + Account + ",GameName=" + GameName + ",ServerName=" + ServerName + ",BetAmount=" + BetAmount + ",Score=" + Score + ",Revenue=" + Revenue + ",PlayerId=" + PlayerId + ",ServerId=" + ServerId + ",GameId=" + GameId + ",StartTime=" + StartTime + ",EndTime=" + EndTime + ",GameCode=" + GameCode + ",CreateTime=" + CreateTime + ",IsDelete=" + IsDelete + "]";
    }
        
    
}
    