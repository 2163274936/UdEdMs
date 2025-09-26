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
    public String getTrackingNumber() {
        return trackingNumber;
    }
    //永久保存快递属于转为csv文本文件
    // 把对象转成一行字符串，用于保存到文件
    public String toCSV() {
        return studentName + "," + studentId + "," + company + "," + trackingNumber + "," + (pickedUp ? "已取件" : "取件");
    }
    //从一行csv创建对象
    /**
     * 静态方法：将CSV格式的一行字符串解析并转换为PackageInfo对象
     *
     * 功能说明：
     * 该方法是CSV数据与PackageInfo对象之间的转换器，
     * 接收一个符合格式的CSV行字符串，按规则解析后创建并返回对应的对象，
     * 常用于从CSV文件读取数据时进行格式转换
     *
     * @param line 单个CSV行字符串，格式要求："姓名,学号,快递公司,快递单号,状态"
     *             例如："张三,2024001,顺丰,SF123456,已取件"
     * @return 转换后的PackageInfo对象，包含解析出的所有快递信息
     * @throws IllegalArgumentException 当CSV行格式错误（字段数量不是5个）时抛出
     */
    public static PackageInfo fromCSV(String line){
        // 1. 按CSV的“逗号分隔”规则，把一行字符串拆成数组
        // 例：CSV行“张三,2024001,顺丰,SF123456,已取件”会拆成 ["张三","2024001","顺丰","SF123456","已取件"]
        String[] parts = line.split(",");
        // 2. 校验CSV格式是否正确：必须包含5个字段（姓名、学号、公司、单号、状态）
        // 若字段数不对，直接抛出异常，提示格式错误
        if(parts.length != 5) {
            throw new IllegalArgumentException("Invalid CSV line: " + line);
        }
        // 3. 用拆分后的前4个字段，创建PackageInfo对象（基础信息）
        PackageInfo p = new PackageInfo(parts[0], parts[1], parts[2], parts[3]);
        if ("已取件".equals(parts[4])) {
            // 4. 根据第5个字段（状态）设置对象的pickedUp属性
            p.PickUp(); // 如果状态是“已取件”，调用PickUp方法标记为已取
        }
        // 5. 返回创建并初始化好的PackageInfo对象
        return p;
    }
    @Override
    public String toString() {
        return "姓名：" + studentName + ", 单号：" + trackingNumber +
                ",快递公司：" + company + "，状态：" + (pickedUp ? "已取件" : "取件");
    } //三元运算符，相当于一个简化版的 if-else，写法是 条件 ? 结果1 : 结果2。

    public String getStudentId() {
        return studentId;
    }
}
