package lt.ehu.student.moneytrackerbeta.model;

import java.math.BigDecimal;

public class Asset extends AbstractModel {
    private String id;
    private final int userId;
    private String name;
    private String description;
    private BigDecimal initBalance;
    private BigDecimal currentBalance;
    private int currency;

    public Asset(String id, int userId, String name, String description, BigDecimal initBalance, BigDecimal currentBalance, int currency) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.initBalance = initBalance;
        this.currentBalance = currentBalance;
        this.currency = currency;
    }

    public Asset(int userId, String name, String description, BigDecimal initBalance, BigDecimal currentBalance, int currency) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.initBalance = initBalance;
        this.currentBalance = currentBalance;
        this.currency = currency;
    }

    public Asset(int userId, String name, BigDecimal initBalance) {
        this.userId = userId;
        this.name = name;
        this.description = null;
        this.initBalance = initBalance;
        this.currentBalance = initBalance;
        this.currency = 1;
    }


    public String getId() {
        return id;
    }
    public int getUserId() {
        return userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public BigDecimal getInitBalance() {
        return initBalance;
    }
    public void setInitBalance(BigDecimal initBalance) {
        this.initBalance = initBalance;
    }
    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }
    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }
    public int getCurrency() {
        return currency;
    }
    public void setCurrency(int currency) {
        this.currency = currency;
    }
}
