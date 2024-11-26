
import java.text.SimpleDateFormat;
import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PersonalFinance extends javax.swing.JFrame {

    public PersonalFinance() {
        initComponents();
    }

    private DefaultTableModel model;
    private TransactionList transactions = new TransactionList();
    private Stack<Transaction> undoStack = new Stack<>();
    SimpleDateFormat dateFormat;

    class Transaction {

        String wow;
        String txt;
        double amo;
        String theDate;
        Transaction next;

        public Transaction(String date, String description, String type, double amount) {
            this.wow = type;
            this.amo = amount;
            this.theDate = date;
            this.txt = description;
            this.next = null;
        }

        @Override
        public String toString() {
            return wow + " | Amount: " + amo + " | Date: " + txt + " | Description: ";
        }
    }

    class TransactionList {

        private Transaction head;

        public void addTransaction(String type, double amount, String date, String description) {
            Transaction newTransaction = new Transaction(date, description, type, amount);
            if (head == null) {
                head = newTransaction;
            } else {
                Transaction current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newTransaction;
            }
        }
        public void displayTransactions() {
            model.setRowCount(0);
            Transaction current = head;
            while (current != null) {
                model.addRow(new Object[]{current.theDate, current.txt, current.wow, current.amo});
                current = current.next;
            }
        }
        public void sortTransactions(boolean byAmount) {
            if (head == null || head.next == null) {
                JOptionPane.showMessageDialog(null, "No transactions to sort.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            boolean swapped;
            do {
                swapped = false;
                Transaction current = head;
                while (current.next != null) {
                    boolean condition = byAmount
                            ? current.amo > current.next.amo
                            : current.theDate.compareTo(current.next.theDate) > 0;
                    if (condition) {
                        String tempType = current.wow;
                        double tempAmount = current.amo;
                        String tempDate = current.theDate;
                        String tempDescription = current.txt;

                        current.wow = current.next.wow;
                        current.amo = current.next.amo;
                        current.theDate = current.next.theDate;
                        current.txt = current.next.txt;

                        current.next.wow = tempType;
                        current.next.amo = tempAmount;
                        current.next.theDate = tempDate;
                        current.next.txt = tempDescription;

                        swapped = true;
                    }
                    current = current.next;
                }
            } while (swapped);

            JOptionPane.showMessageDialog(null, "Transactions sorted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        }

        public Transaction removeLastTransaction() {
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                Transaction temp = head;
                head = null;
                return temp;
            }
            Transaction current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            Transaction temp = current.next;
            current.next = null;
            return temp;
        }

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        list = new javax.swing.JTable();
        sorta = new javax.swing.JButton();
        sortd = new javax.swing.JButton();
        undo = new javax.swing.JButton();
        total = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        script = new javax.swing.JTextField();
        type = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        money = new javax.swing.JTextField();
        d = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        undo1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Personal Finance Management");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setBackground(java.awt.SystemColor.activeCaption);
        jPanel3.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jLabel5.setText("PERSONAL FINANCE MANAGEMENT");
        jPanel3.add(jLabel5);

        jPanel2.setBackground(java.awt.SystemColor.activeCaption);
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bal.setText("Balance:");
        bal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balActionPerformed(evt);
            }
        });
        jPanel2.add(bal, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 400, 140, 30));

        list.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Description", "Type", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        list.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                listAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(list);
        if (list.getColumnModel().getColumnCount() > 0) {
            list.getColumnModel().getColumn(0).setResizable(false);
            list.getColumnModel().getColumn(1).setResizable(false);
            list.getColumnModel().getColumn(2).setResizable(false);
            list.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 130, 780, 254));

        sorta.setText("Sort by Amount");
        sorta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortaActionPerformed(evt);
            }
        });
        jPanel2.add(sorta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        sortd.setText("Sort by Date");
        sortd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortdActionPerformed(evt);
            }
        });
        jPanel2.add(sortd, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, -1, -1));

        undo.setText("Undo");
        undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoActionPerformed(evt);
            }
        });
        jPanel2.add(undo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, -1, -1));

        total.setText("Total Balance");
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });
        jPanel2.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, -1, -1));

        jLabel3.setText("Description:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        jPanel2.add(script, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 160, -1));

        type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Expense", "Income" }));
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });
        jPanel2.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 120, -1));

        jLabel4.setText("Type:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));

        jLabel1.setText("Amount:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, -1, -1));

        money.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moneyActionPerformed(evt);
            }
        });
        jPanel2.add(money, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 120, -1));
        jPanel2.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 140, -1));

        jLabel2.setText("Date:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, -1, -1));

        undo1.setText("Undo");
        undo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undo1ActionPerformed(evt);
            }
        });
        jPanel2.add(undo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, -1, -1));

        jPanel3.add(jPanel2);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void undo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_undo1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String theDate;
        try {
            theDate = dateFormat.format(d.getDate());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Please select a valid date.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String txt = script.getText().trim();
        String wow = (String) type.getSelectedItem();
        String amo = money.getText().trim();

        double amount;
        try {
            amount = Double.parseDouble(amo);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid amount entered.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        model = (DefaultTableModel) list.getModel();
        model.addRow(new Object[]{theDate, txt, wow, amount});

        Transaction transaction = new Transaction(theDate, txt, wow, amount);
        undoStack.push(transaction);
        transactions.addTransaction(wow, amount, theDate, txt);

        JOptionPane.showMessageDialog(null, "Transaction added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void moneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moneyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moneyActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        double totalBalance = 0.0;
        Transaction current = transactions.head;

        while (current != null) {
            if ("Income".equalsIgnoreCase(current.wow)) {
                totalBalance += current.amo;
            } else if ("Expense".equalsIgnoreCase(current.wow)) {
                totalBalance -= current.amo;
            }
            current = current.next;
        }
        bal.setText("Balance: P" + totalBalance);
    }//GEN-LAST:event_totalActionPerformed

    private void undoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoActionPerformed
        if (undoStack.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No transactions to undo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Transaction removed = undoStack.pop();
        transactions.removeLastTransaction();
        transactions.displayTransactions();
        JOptionPane.showMessageDialog(null, "Last transaction undone.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_undoActionPerformed

    private void sortdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortdActionPerformed
        transactions.sortTransactions(false);
        transactions.displayTransactions();
    }//GEN-LAST:event_sortdActionPerformed

    private void sortaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortaActionPerformed
        transactions.sortTransactions(true);
        transactions.displayTransactions();
    }//GEN-LAST:event_sortaActionPerformed

    private void listAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_listAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_listAncestorAdded

    private void balActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_balActionPerformed

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PersonalFinance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonalFinance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonalFinance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonalFinance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonalFinance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bal;
    private com.toedter.calendar.JDateChooser d;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable list;
    private javax.swing.JTextField money;
    private javax.swing.JTextField script;
    private javax.swing.JButton sorta;
    private javax.swing.JButton sortd;
    private javax.swing.JButton total;
    private javax.swing.JComboBox type;
    private javax.swing.JButton undo;
    private javax.swing.JButton undo1;
    // End of variables declaration//GEN-END:variables

}
