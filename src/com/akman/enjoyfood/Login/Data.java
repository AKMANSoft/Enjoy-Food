package com.akman.enjoyfood.Login;

import javax.annotation.Generated;
import org.json.JSONObject;

@Generated("org.jsonschema2pojo")
public class Data {

    private String id;
    private String storeId;
    private String storeGroup;
    private String name;
    private String surname;
    private String userType;
    private String checkerUsers;
    private String email;
    private String username;
    private String tableGrp;
    private String bartenderIds;
    private String waiterIds;
    private String image;
    private String imageName;
    private String runningItem;
    private String busyTime;
    private String cashReceivedDate;
    private String orderId;
    private String gcmToken;
    private String mtype;
    private String status;
    private String random;
    private String isActiveManager;
    private String isLogin;
    private String key;


    public Data(JSONObject obj) {

        id = obj.getString("id");
        storeId = obj.getString("store_id");
        storeGroup = obj.getString("store_group");
        name = obj.getString("name");
        surname = obj.getString("surname");
        userType = obj.getString("user_type");
        checkerUsers = obj.getString("checker_users");
        email = obj.getString("email");
        username = obj.getString("username");
        tableGrp = obj.getString("table_grp");
        bartenderIds = obj.getString("bartender_ids");
        waiterIds = obj.getString("waiter_ids");
        image = obj.getString("image");
        imageName = obj.getString("image_name");
        runningItem = obj.getString("running_item");
        busyTime = obj.getString("busy_time");
        cashReceivedDate = obj.getString("cash_received_date");
        orderId = obj.getString("order_id");
        gcmToken = obj.getString("gcm_token");
        mtype = obj.getString("mtype");
        status = obj.getString("status");
        random = obj.getString("random");
        isActiveManager = obj.getString("is_active_manager");
        isLogin = obj.getString("is_login");
    }

    /**
     *
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return The storeId
     */
    public String getStoreId() {
        return storeId;
    }

    /**
     *
     * @param storeId The store_id
     */
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    /**
     *
     * @return The storeGroup
     */
    public String getStoreGroup() {
        return storeGroup;
    }

    /**
     *
     * @param storeGroup The store_group
     */
    public void setStoreGroup(String storeGroup) {
        this.storeGroup = storeGroup;
    }

    /**
     *
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return The surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     *
     * @param surname The surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     *
     * @return The userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     *
     * @param userType The user_type
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     *
     * @return The checkerUsers
     */
    public String getCheckerUsers() {
        return checkerUsers;
    }

    /**
     *
     * @param checkerUsers The checker_users
     */
    public void setCheckerUsers(String checkerUsers) {
        this.checkerUsers = checkerUsers;
    }

    /**
     *
     * @return The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return The tableGrp
     */
    public String getTableGrp() {
        return tableGrp;
    }

    /**
     *
     * @param tableGrp The table_grp
     */
    public void setTableGrp(String tableGrp) {
        this.tableGrp = tableGrp;
    }

    /**
     *
     * @return The bartenderIds
     */
    public String getBartenderIds() {
        return bartenderIds;
    }

    /**
     *
     * @param bartenderIds The bartender_ids
     */
    public void setBartenderIds(String bartenderIds) {
        this.bartenderIds = bartenderIds;
    }

    /**
     *
     * @return The waiterIds
     */
    public String getWaiterIds() {
        return waiterIds;
    }

    /**
     *
     * @param waiterIds The waiter_ids
     */
    public void setWaiterIds(String waiterIds) {
        this.waiterIds = waiterIds;
    }

    /**
     *
     * @return The image
     */
    public String getImage() {
        return image;
    }

    /**
     *
     * @param image The image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     *
     * @return The imageName
     */
    public String getImageName() {
        return imageName;
    }

    /**
     *
     * @param imageName The image_name
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    /**
     *
     * @return The runningItem
     */
    public String getRunningItem() {
        return runningItem;
    }

    /**
     *
     * @param runningItem The running_item
     */
    public void setRunningItem(String runningItem) {
        this.runningItem = runningItem;
    }

    /**
     *
     * @return The busyTime
     */
    public String getBusyTime() {
        return busyTime;
    }

    /**
     *
     * @param busyTime The busy_time
     */
    public void setBusyTime(String busyTime) {
        this.busyTime = busyTime;
    }

    /**
     *
     * @return The cashReceivedDate
     */
    public String getCashReceivedDate() {
        return cashReceivedDate;
    }

    /**
     *
     * @param cashReceivedDate The cash_received_date
     */
    public void setCashReceivedDate(String cashReceivedDate) {
        this.cashReceivedDate = cashReceivedDate;
    }

    /**
     *
     * @return The orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     *
     * @param orderId The order_id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     *
     * @return The gcmToken
     */
    public String getGcmToken() {
        return gcmToken;
    }

    /**
     *
     * @param gcmToken The gcm_token
     */
    public void setGcmToken(String gcmToken) {
        this.gcmToken = gcmToken;
    }

    /**
     *
     * @return The mtype
     */
    public String getMtype() {
        return mtype;
    }

    /**
     *
     * @param mtype The mtype
     */
    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    /**
     *
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return The random
     */
    public String getRandom() {
        return random;
    }

    /**
     *
     * @param random The random
     */
    public void setRandom(String random) {
        this.random = random;
    }

    /**
     *
     * @return The isActiveManager
     */
    public String getIsActiveManager() {
        return isActiveManager;
    }

    /**
     *
     * @param isActiveManager The is_active_manager
     */
    public void setIsActiveManager(String isActiveManager) {
        this.isActiveManager = isActiveManager;
    }

    /**
     *
     * @return The isLogin
     */
    public String getIsLogin() {
        return isLogin;
    }

    /**
     *
     * @param isLogin The is_login
     */
    public void setIsLogin(String isLogin) {
        this.isLogin = isLogin;
    }


    /**
     *
     * @return The key
     */
    public String getKey() {
        return key;
    }

    /**
     *
     * @param key The key
     */
    public void setKey(String key) {
        this.key = key;
    }


}
