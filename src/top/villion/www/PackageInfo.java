package top.villion.www;

public class PackageInfo {
    private String studentName;
    private String studentId;
    private String company;
    private String trackingNumber;
    private boolean pickedUp;

    /**
     * 构造方法，初始化包裹信息
     * 新建包裹时默认状态为"未取"
     *
     * @param studentName    学生姓名
     * @param studentId      学生ID
     * @param company        快递公司名称
     * @param trackingNumber 快递单号
     */
    public PackageInfo(String studentName, String studentId, String company, String trackingNumber) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.company = company;
        this.trackingNumber = trackingNumber;
        this.pickedUp = false;
    }

    /**
     * 标记包裹为"已取"状态
     * 调用此方法后，包裹状态将从"未取"变为"已取"
     */
    public void PickUp() {
        this.pickedUp = true;
    }

    /**
     * 重写toString方法，返回包裹的详细信息字符串
     * 包含姓名、单号、快递公司和当前状态
     *
     * @return 格式化的包裹信息字符串
     */
    @Override
    public String toString() {
        return "姓名：" + studentName + ", 单号：" + trackingNumber +
                ",快递公司：" + company + "，状态：" + (pickedUp ? "已取件" : "取件");
    } //三元运算符，相当于一个简化版的 if-else，写法是 条件 ? 结果1 : 结果2。

    public String getStudentId() {
        return studentId;
    }
}
