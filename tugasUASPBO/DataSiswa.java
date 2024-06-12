package tugasUASPBO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public final class DataSiswa extends javax.swing.JFrame {
    
    private final DefaultTableModel model;
    private final JTable updateTable = null;

    public DataSiswa() {
        initComponents();
        model = (DefaultTableModel) tbDataSiswa.getModel();
        updateTable();
        loadDataToTable();
    }
    

     public void updateTable() {
        model.setRowCount(0); // Menghapus semua baris yang ada dalam model
        try {
            Connection conn = koneksi.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tb_pendaftaran");

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_pendaftaran"),
                    rs.getString("nama"),
                    rs.getString("tempat_lahir"),
                    rs.getString("tanggal_lahir"),
                    rs.getString("agama"),
                    rs.getString("asal_sekolah"),
                    rs.getString("alamat_pendaftar"),
                    rs.getString("jenis_kelamin")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
     
     private void loadDataToTable() {
        DefaultTableModel model = (DefaultTableModel) tbDataSiswa.getModel();
        model.setRowCount(0); // Bersihkan tabel sebelum memuat data baru

        String query = "SELECT * FROM tb_pendaftaran";

        try (Connection conn = koneksi.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int id_pendaftaran = rs.getInt("id_pendaftaran");
                    String nama = rs.getString("nama");
                    String tempat = rs.getString("tempat_lahir");
                    String tanggal = rs.getString("tanggal_lahir");
                    String agama = rs.getString("agama");
                    String asalSekolah = rs.getString("asal_sekolah");
                    String alamat = rs.getString("alamat_pendaftar");
                    String jenis_kelamin = rs.getString("jenis_kelamin");

                    // Tambahkan data ke model tabel
                    model.addRow(new Object[]{id_pendaftaran, nama, tempat, tanggal, agama, asalSekolah, alamat, jenis_kelamin});
                }
            }

        } catch (SQLException e) {
            // Tampilkan pesan error yang lebih spesifik
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbDataSiswa = new javax.swing.JTable();
        btnCari = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btnKembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(5, 29, 64));
        jPanel2.setMinimumSize(new java.awt.Dimension(800, 150));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 150));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(173, 131, 48));
        jLabel1.setText("DATA SISWA");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tugasUASPBO/smk bisa.png"))); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(200, 175));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(459, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tbDataSiswa.setBackground(new java.awt.Color(5, 29, 64));
        tbDataSiswa.setForeground(new java.awt.Color(173, 131, 48));
        tbDataSiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Pendaftaran", "Nama", "Tempat Lahir", "Tanggal Lahir", "Agama", "Asal Sekolah", "Alamat Pendaftar", "Jenis Kelamin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbDataSiswa.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbDataSiswaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tbDataSiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDataSiswaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbDataSiswa);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 740, 231));

        btnCari.setBackground(new java.awt.Color(5, 29, 64));
        btnCari.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCari.setForeground(new java.awt.Color(173, 131, 48));
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });
        getContentPane().add(btnCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 70, -1));
        getContentPane().add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 200, 23));

        btnKembali.setBackground(new java.awt.Color(5, 29, 64));
        btnKembali.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKembali.setForeground(new java.awt.Color(173, 131, 48));
        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });
        getContentPane().add(btnKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 462, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbDataSiswaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbDataSiswaAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tbDataSiswaAncestorAdded

    private void tbDataSiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDataSiswaMouseClicked
        int i = tbDataSiswa.getSelectedRow();
        TableModel tm = tbDataSiswa.getModel();

        // Ambil data dari baris yang dipilih
        String id_pendaftaran = tm.getValueAt(i, 0).toString();
        String nama = tm.getValueAt(i, 1).toString();
        String tempat_lahir = tm.getValueAt(i, 2).toString();
        String tanggal_lahir = tm.getValueAt(i, 3).toString();
        String agama = tm.getValueAt(i, 4).toString();
        String asal_sekolah = tm.getValueAt(i, 5).toString();
        String alamat_pendaftar = tm.getValueAt(i, 6).toString();
        String jenis_kelamin = tm.getValueAt(i, 7).toString();

        FormPendaftaran formpendaftaran = new FormPendaftaran();

        formpendaftaran.txtID.setText(id_pendaftaran);
        formpendaftaran.txtNama.setText(nama);
        formpendaftaran.txtTempatLahir.setText(tempat_lahir);
        formpendaftaran.cbAgama.setSelectedItem(agama);
        formpendaftaran.txtAsalSekolah.setText(asal_sekolah);
        formpendaftaran.txtAlamat.setText(alamat_pendaftar);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
        Date date = dateFormat.parse(tanggal_lahir);
        formpendaftaran.dtTanggalLahir.setDate(date);
    } catch (ParseException e) {
        e.printStackTrace();
    }
        
        // Set radio button untuk jenis kelamin
    if (jenis_kelamin.equals("Laki-laki")) {
        formpendaftaran.rLaki.setSelected(true);
    } else {
        formpendaftaran.rPerempuan.setSelected(true);
    }

        formpendaftaran.setVisible(true);
    }//GEN-LAST:event_tbDataSiswaMouseClicked

    
    
    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
         String keyword = txtCari.getText(); // Ambil kata kunci pencarian dari JTextField txtCari
//
        try {
            Connection conn = koneksi.getConnection();
            String query = "SELECT * FROM `tb_pendaftaran` WHERE `nama` LIKE ? OR `id_pendaftaran` LIKE ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, "%" + keyword + "%");
                pstmt.setString(2, "%" + keyword + "%");
                ResultSet rs = pstmt.executeQuery();

                DefaultTableModel model = (DefaultTableModel) tbDataSiswa.getModel();
                model.setRowCount(0); // Menghapus semua baris dalam tabel

                while (rs.next()) {
                    Object[] row = {
                        rs.getString("id_pendaftaran"),
                        rs.getString("nama"),
                        rs.getString("tempat_lahir"),
                        rs.getString("tanggal_lahir"),
                        rs.getString("agama"),
                        rs.getString("asal_sekolah"),
                        rs.getString("alamat_pendaftar"),
                        rs.getString("jenis_kelamin")
                    };
                    model.addRow(row); // Menambahkan baris hasil pencarian ke dalam tabel
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        new FormPendaftaran().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new DataSiswa().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnKembali;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTable tbDataSiswa;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables

}
