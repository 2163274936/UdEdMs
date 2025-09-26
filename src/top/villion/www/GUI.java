package top.villion.www;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI {

    private ArrayList<PackageInfo> packages;
    private JFrame frame;
    private JTextField nameField, idField, companyField, trackingField;
    private JTextArea displayArea;

    public GUI(ArrayList<PackageInfo> packages) {
        this.packages = packages;
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("寝室快递管理系统");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // 登录
        frame.add(new JLabel("姓名:"));
        nameField = new JTextField(10);
        frame.add(nameField);
        frame.add(new JLabel("学号:"));
        idField = new JTextField(10);
        frame.add(idField);
        JButton loginBtn = new JButton("登录");
        frame.add(loginBtn);

        // 添加快递
        frame.add(new JLabel("快递公司:"));
        companyField = new JTextField(10);
        frame.add(companyField);
        frame.add(new JLabel("单号:"));
        trackingField = new JTextField(10);
        frame.add(trackingField);
        JButton addBtn = new JButton("添加快递");
        frame.add(addBtn);

        // 取快递
        JButton pickBtn = new JButton("取快递");
        frame.add(pickBtn);

        // 显示区域
        displayArea = new JTextArea(10, 40);
        displayArea.setEditable(false);
        frame.add(new JScrollPane(displayArea));

        // 登录事件
        loginBtn.addActionListener(e -> {
            displayArea.append("登录成功！你好，" + nameField.getText() + "\n");
        });

        // 添加快递事件
        addBtn.addActionListener(e -> {
            String name = nameField.getText();
            String id = idField.getText();
            String company = companyField.getText();
            String tracking = trackingField.getText();
            if (name.isEmpty() || id.isEmpty() || company.isEmpty() || tracking.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "请填写所有信息");
                return;
            }
            PackageInfo p = new PackageInfo(name, id, company, tracking);
            packages.add(p);
            displayArea.append("添加快递成功：" + p + "\n");
        });

        // 取快递事件
        pickBtn.addActionListener(e -> {
            String id = idField.getText();
            String tracking = trackingField.getText();
            boolean found = false;
            for (PackageInfo p : packages) {
                if (p.getStudentId().equals(id) && p.getTrackingNumber().equals(tracking)) {
                    p.PickUp();
                    displayArea.append("快递已取：" + p + "\n");
                    found = true;
                    break;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(frame, "未找到快递或不是你的快递！");
            }
        });

        frame.setVisible(true);
    }
}