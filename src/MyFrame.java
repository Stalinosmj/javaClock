import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyFrame extends JFrame {

    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;

    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;

    String currentTime, Day, Date;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.black);
        this.setTitle("Clock");
        this.setLayout(new FlowLayout());
        this.setMinimumSize(new Dimension(600, 200));
        this.setResizable(true);
        this.setTitle("Clock");

        timeFormat = new SimpleDateFormat("     hh:mm:ss a    ");
        dayFormat = new SimpleDateFormat("   EEEE   ");
        dateFormat = new SimpleDateFormat("   MMMMM dd, yyyy   ");

        timeLabel = new JLabel();
        timeLabel.setFont(new java.awt.Font("Verdana", Font.BOLD, 50));
        timeLabel.setForeground(new java.awt.Color(144, 238, 144));
        timeLabel.setBackground(new java.awt.Color(2, 48, 32));
        timeLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setVerticalAlignment(JLabel.CENTER);
        timeLabel.setOpaque(true);
        this.add(timeLabel);

        dayLabel = new JLabel();
        dayLabel.setFont(new java.awt.Font("SansSerif", Font.ITALIC, 40));
        dayLabel.setForeground(new java.awt.Color(144, 238, 144));
        dayLabel.setBackground(new java.awt.Color(2, 48, 32));
        dayLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dayLabel.setHorizontalAlignment(JLabel.CENTER);
        dayLabel.setVerticalAlignment(JLabel.CENTER);
        dayLabel.setOpaque(true);
        this.add(dayLabel);

        dateLabel = new JLabel();
        dateLabel.setFont(new java.awt.Font("Helvetica", Font.ITALIC, 40));
        dateLabel.setForeground(new java.awt.Color(144, 238, 144));
        dateLabel.setBackground(new java.awt.Color(2, 48, 32));
        dateLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dateLabel.setHorizontalAlignment(JLabel.CENTER);
        dateLabel.setVerticalAlignment(JLabel.CENTER);
        dateLabel.setOpaque(true);
        this.add(dateLabel);

        String[] timezones = TimeZone.getAvailableIDs();
        JComboBox<String> timezoneComboBox = new JComboBox<>(timezones);
        timezoneComboBox.setFont(new java.awt.Font("Helvetica", Font.PLAIN, 20));
        timezoneComboBox.setForeground(new java.awt.Color(144, 238, 144));
        timezoneComboBox.setBackground(new java.awt.Color(2, 48, 32));

        timezoneComboBox.addActionListener
        (new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedTimezone = (String) timezoneComboBox.getSelectedItem();
        TimeZone timeZone = TimeZone.getTimeZone(selectedTimezone);
        Calendar calendar = Calendar.getInstance(timeZone);

        String currentTime = timeFormat.format(calendar.getTime());
        timeLabel.setText(currentTime);

        String day = dayFormat.format(calendar.getTime());
        dayLabel.setText(day);

        String date = dateFormat.format(calendar.getTime());
        dateLabel.setText(date);
    }
});

this.add(timezoneComboBox);

this.setVisible(true);
setTime();
}

public void setTime() {
while (true) {
    Calendar calendar = Calendar.getInstance();

    String currentTime = timeFormat.format(calendar.getTime());
    timeLabel.setText(currentTime);

    String day = dayFormat.format(calendar.getTime());
    dayLabel.setText(day);

    String date = dateFormat.format(calendar.getTime());
    dateLabel.setText(date);

    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
}
}