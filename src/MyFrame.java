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

public class MyFrame extends JFrame {

    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    SimpleDateFormat timelineFormat;

    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    JLabel timelineLabel;

    String currentTime, Day, Date, timeline;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.black);
        this.setTitle("Clock");
        this.setLayout(new FlowLayout());
        this.setMinimumSize(new Dimension(640, 300));
        this.setResizable(true);
        this.setTitle("Clock");

        timeFormat = new SimpleDateFormat("     hh:mm:ss a    ");
        dayFormat = new SimpleDateFormat("   EEEE   ");
        dateFormat = new SimpleDateFormat("   MMMMM dd, yyyy   ");
        timelineFormat = new SimpleDateFormat("  zzzz  ");

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

        timelineLabel = new JLabel();
        timelineLabel.setFont(new java.awt.Font("Helvetica", Font.PLAIN, 20));
        timelineLabel.setForeground(new java.awt.Color(144, 238, 144));
        timelineLabel.setBackground(new java.awt.Color(2, 48, 32));
        timelineLabel.setHorizontalAlignment(JLabel.RIGHT);
        timelineLabel.setVerticalAlignment(JLabel.BOTTOM);
        timelineLabel.setOpaque(true);
        this.add(timelineLabel);

        String[] timezones = TimeZone.getAvailableIDs();

        // Create a JComboBox instance for the drop-down list
        JComboBox<String> timelineComboBox = new JComboBox<>(timezones);
        timelineComboBox.setFont(new java.awt.Font("Helvetica", Font.PLAIN, 20));
        timelineComboBox.setForeground(new java.awt.Color(144, 238, 144));
        timelineComboBox.setBackground(new java.awt.Color(2, 48, 32));
        timelineComboBox.setEditable(false);
        String initialTimezone = "Asia/Kolkata"; // Set the default timezone
       
                timelineComboBox.setSelectedItem(initialTimezone);

        // Add an action listener to perform actions when the selection changes
        timelineComboBox.addActionListener(e -> {
            String selectedTimezone = (String) timelineComboBox.getSelectedItem();
            // Perform actions based on the selected timezone
            TimeZone timeZone = TimeZone.getTimeZone(selectedTimezone);
            // Set the desired timezone for the Calendar instance
            Calendar calendar = Calendar.getInstance(timeZone);

            // Update the timeLabel with the updated time
            String currentTime = timeFormat.format(calendar.getTime());
            timeLabel.setText(currentTime);

            // Update the dayLabel with the updated day
            String day = dayFormat.format(calendar.getTime());
            dayLabel.setText(day);

            // Update the dateLabel with the updated date
            String date = dateFormat.format(calendar.getTime());
            dateLabel.setText(date);

            // Update the timelineLabel with the updated timeline
            String timeline = timelineFormat.format(calendar.getTime());
            timelineLabel.setText(timeline);
        });

        // Add the JComboBox to the container or component
        this.add(timelineComboBox);

        this.setVisible(true);
        setTime();
    }

    public void setTime() {

        while (true) {
            Calendar calendar = Calendar.getInstance();
            currentTime = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(currentTime);
            // Day = dayFormat.format(calendar.getTime());
            // dayLabel.setText(Day);
            // Date = dateFormat.format(calendar.getTime());
            // dateLabel.setText(Date);
            
            
            


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
