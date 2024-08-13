/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pro1041.com.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pro1041.com.entity.KhachHang;
import pro1041.com.service.KhachHangService;

/**
 *
 * @author Tom
 */
public class formKhachHang extends javax.swing.JPanel {
     DefaultTableModel model = new DefaultTableModel();
    private KhachHangService khachHangService = new KhachHangService();
    private DefaultTableModel tbm = new DefaultTableModel();
    private List<KhachHang> dskh = new ArrayList<>();
    public static String maKH;

    /**
     * Creates new form formKhachHang
     */
    public formKhachHang() {
        initComponents();
        setSize(1000, 1000);
        dskh = khachHangService.getAll();
        tbm = (DefaultTableModel) tblKhachHang.getModel();
        showDuLieu();
        clearForm();
        taoMa();
        txtMa.setText(maKH);
    }

    private void checkEditingStatus(JTable table) {
        boolean isEditing = table.isEditing();
        if (isEditing == false) {
        }
    }

    private void taoMa() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder("KH");
        for (int i = 0; i < 4; i++) {
            int x = random.nextInt(10);
            sb.append(x);
        }
        maKH = sb.toString();
    }

    public void showDuLieu() {
        tbm.setRowCount(0);
        for (KhachHang kh : dskh) {
            tbm.addRow(new Object[]{
                kh.getId_khachHang(), kh.getMaKh(), kh.getHoTenKh(), kh.getGioiTinh(), kh.getDiaChi(), kh.getSdt(), kh.getNgayTao(), kh.getNgaySua()
            });

        }
    }

    public void showDetail(int index) {
        KhachHang kh = dskh.get(index);
        txtMa.setText(kh.getMaKh());
        txtTen.setText(kh.getHoTenKh());
        txtDiaChi.setText(kh.getDiaChi());
        txtSoDienThoai.setText(kh.getSdt());

        jNgayTao.setDate(kh.getNgayTao());
        jNgaySua.setDate(kh.getNgaySuaOrDefault());
        String gioiTinh = kh.getGioiTinh();
        if (gioiTinh != null) {
            if (gioiTinh.equalsIgnoreCase("Nam")) {
                rdoNam.setSelected(true);
            } else if (gioiTinh.equalsIgnoreCase("Nữ")) {
                rdoNu.setSelected(true);
            } else {
                rdoNam.setSelected(false);
                rdoNu.setSelected(false);
            }
        } else {
            rdoNam.setSelected(false);
            rdoNu.setSelected(false);
        }
    }

    public KhachHang getForm() {
        KhachHang kh = new KhachHang();
        String ma = txtMa.getText().trim();
        String ten = txtTen.getText().trim();
        String sdt = txtSoDienThoai.getText().trim();
        String diaChi = txtDiaChi.getText().trim();
        Date ngayTao = jNgayTao.getDate();
        Date ngaySua = jNgaySua.getDate();
        String gioiTinh = "";
        if (rdoNam.isSelected()) {
            gioiTinh = "Nam";
        } else if (rdoNu.isSelected()) {
            gioiTinh = "Nữ";
        }
        kh.setHoTenKh(ten);
        kh.setDiaChi(diaChi);
        kh.setMaKh(ma);
        kh.setSdt(sdt);
        kh.setNgayTao(ngayTao);
        kh.setNgaySua(ngaySua);
        kh.setGioiTinh(gioiTinh);
        return kh;
    }

    void clearForm() {
        txtDiaChi.setText("");
        txtMa.setText("");
        txtSoDienThoai.setText("");
        txtTen.setText("");
        buttonGroup1.clearSelection();
        Date now = new Date();
        jNgayTao.setDate(now);
        jNgaySua.setDate(now);
    }
    private boolean isValidMaKh(String maKh) {
    return maKh != null && maKh.trim().matches("(?i)^KH\\d+$");
}
    public void loadAllKhachHang() {
    List<KhachHang> lstKH = khachHangService.getAll(); // Giả sử bạn có phương thức này
    model.setRowCount(0); // Xóa các dòng hiện tại trong bảng

    for (KhachHang kh : lstKH) {
        Object row[] = new Object[]{
            kh.getId_khachHang(),
            kh.getMaKh(),
            kh.getHoTenKh(),
            kh.getDiaChi(),
            kh.getGioiTinh(),
            kh.getEmail(),
            kh.getSdt(),
            kh.getNgayTao(),
            kh.getNgaySua()
        };
        model.addRow(row);
    }
}
    public void loadTableKhachHang(List<KhachHang> khachHangs) {
    model = (DefaultTableModel) tblKhachHang.getModel();
    model.setRowCount(0); // Xóa các dòng hiện tại trong bảng

    for (KhachHang kh : khachHangs) {
        Object row[] = new Object[]{
            kh.getId_khachHang(),
            kh.getMaKh(),
            kh.getHoTenKh(),
            kh.getDiaChi(),
            kh.getGioiTinh(),
            kh.getEmail(),
            kh.getSdt(),
            kh.getNgayTao(),
            kh.getNgaySua()
        };
        model.addRow(row);
    }
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jNgayTao = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jNgaySua = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiemSanPham = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel1.setText("THÔNG TIN KHÁCH HÀNG");
        jLabel1.setPreferredSize(new java.awt.Dimension(263, 28));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("MÃ KHÁCH HÀNG");

        txtMa.setEnabled(false);
        txtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("NGÀY TẠO ");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("NGÀY SỬA");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("TÊN KHÁCH HÀNG");

        txtTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("GIỚI TÍNH");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("NAM");
        rdoNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNamActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNu);
        rdoNu.setText("NỮ");
        rdoNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNuActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("ĐỊA CHỈ");

        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("SỐ ĐIỆN THOẠI");

        txtSoDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDienThoaiActionPerformed(evt);
            }
        });

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro1041/com/icon/icons8-add-16.png"))); // NOI18N
        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro1041/com/icon/icons8-update-16.png"))); // NOI18N
        btnSua.setText("SỬA");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro1041/com/icon/remove_7695824 (1).png"))); // NOI18N
        btnXoa.setText("XÓA");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro1041/com/icon/synchronize_2749336.png"))); // NOI18N
        btnLamMoi.setText("LÀM MỚI");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLamMoi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnLamMoi))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID KHÁCH HÀNG", "MÃ KH", "TÊN KH", "GIỚI TÍNH", "ĐỊA CHỈ ", "SỐ ĐIỆN THOẠI", "NGÀY TẠO ", "NGÀY SỬA"
            }
        ));
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        btnTimKiemSanPham.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTimKiemSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro1041/com/icon/Search1.png"))); // NOI18N
        btnTimKiemSanPham.setOpaque(true);
        btnTimKiemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemSanPhamActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("TÌM KIẾM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel5))
                                                .addGap(26, 26, 26))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(42, 42, 42)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtMa)
                                        .addComponent(jNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jNgaySua, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(78, 78, 78)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(rdoNam)
                                                .addGap(18, 18, 18)
                                                .addComponent(rdoNu))
                                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(41, 41, 41)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTimKiemSanPham)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(rdoNam)
                        .addComponent(rdoNu)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNgaySua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaActionPerformed

    private void txtTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenActionPerformed

    private void rdoNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNamActionPerformed

    private void rdoNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNuActionPerformed

    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiActionPerformed

    private void txtSoDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoDienThoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoDienThoaiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        String ma = txtMa.getText().trim();
        String ten = txtTen.getText().trim();
        if (ma.isEmpty() && ten.isEmpty() && ma.isBlank() && ten.isBlank()) {
            JOptionPane.showMessageDialog(this, "Tên và mã khách hàng không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (ma.isBlank() || ma.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã khách hàng không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (ten.isBlank() || ten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên khách hàng không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm khách hàng?", "Xác nhận", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            if (khachHangService.add(getForm()) != 0) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                clearForm();
                dskh = khachHangService.getAll();
                showDuLieu();
                taoMa();
                txtMa.setText(maKH);
            } else {
                JOptionPane.showMessageDialog(this, "Thêm không thành công");
            }
        } else {
            showDuLieu();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblKhachHang.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dữ liệu cần cập nhật.");
            return;
        }
        String ma = txtMa.getText().trim();
        String ten = txtTen.getText().trim();
        if (ma.isEmpty() && ten.isEmpty() && ma.isBlank() && ten.isBlank()) {
            JOptionPane.showMessageDialog(this, "Tên và mã khách hàng không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (ma.isBlank() || ma.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã khách hàng không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (ten.isBlank() || ten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên khách hàng không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int id = Integer.parseInt(tblKhachHang.getValueAt(selectedRow, 0).toString());
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật dữ liệu không?", "Xác nhận", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            if (khachHangService.sua(id, getForm()) != 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                clearForm();
                dskh = khachHangService.getAll();
                showDuLieu();
                taoMa();
                txtMa.setText(maKH);
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
            }
        } else {
            showDuLieu();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblKhachHang.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dữ liệu cần xóa.");
            return;
        }

        int id = Integer.parseInt(tblKhachHang.getValueAt(selectedRow, 0).toString());
        int dialogResult = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa dữ liệu này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
            if (khachHangService.xoa(id)) {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                clearForm();
                dskh = khachHangService.getAll();
                showDuLieu();
                taoMa();
                txtMa.setText(maKH);
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        } else {
            showDuLieu();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        // TODO add your handling code here:
        int row = tblKhachHang.getSelectedRow();
        showDetail(row);
        checkEditingStatus(tblKhachHang);
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void btnTimKiemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemSanPhamActionPerformed
        String maKh = txtTimKiem.getText();
        if (maKh == null || maKh.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã khách hàng");
        } else if (!isValidMaKh(maKh)) {
            JOptionPane.showMessageDialog(this, "Mã khách hàng không hợp lệ (ví dụ: KH1)");
        } else {
            List<KhachHang> khachHangs = khachHangService.timKiemKhachHang(maKh);
            if (khachHangs.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng với mã: " + maKh);
                loadAllKhachHang();
            } else {
                loadTableKhachHang(khachHangs);
            }
        }
    }//GEN-LAST:event_btnTimKiemSanPhamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiemSanPham;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JDateChooser jNgaySua;
    private com.toedter.calendar.JDateChooser jNgayTao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
