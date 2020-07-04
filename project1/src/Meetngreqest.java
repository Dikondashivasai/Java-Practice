import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MeetingRequest {

    private static Date fromOfficeTimeDate;//09:00
    private static Date toOfficeTimeDate;//17:30
    private static List<String> allBookings = new ArrayList<>();
    private static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Please enter your office timings: ");
            String officeTime = scanner.nextLine(); // 09:00 17:30

            String[] fromAndToTimings = officeTime.split(" ");
            String fromOfficeTime = fromAndToTimings[0]; // 09:00
            String toOfficeTime = fromAndToTimings[1]; // 17:30

            fromOfficeTimeDate = timeFormat.parse(fromOfficeTime);
            toOfficeTimeDate = timeFormat.parse(toOfficeTime);

            int count = 5;
            int index = 1;

            while (index <= count) {
                index++;
                System.out.println("Please enter your Meeting request submission meetingStartTimeString: ");
                String requestDateTime = scanner.nextLine(); // 2020-08-17 10:17:06 e1

                // Split the give  input requestDateTime by space
                String[] dateTimeAndEmployeeId = requestDateTime.split(" ");
                String requestSubmissionDateString = dateTimeAndEmployeeId[0]; // 2020-08-17
                String requestSubmissionTimeString = dateTimeAndEmployeeId[1]; // 10:17:06
                String employeeId = dateTimeAndEmployeeId[2]; // e1
                String requestSubmissionDateTimeString = requestSubmissionDateString + " " + requestSubmissionTimeString;

                System.out.println("Please enter your Meeting start Time and duration: ");
                String meetingStartTimeAndDuration = scanner.nextLine(); // 2020-08-21 09:00 2

                // Split the given input meetingStartTimeAndDuration by space
                String[] startTimeAndDurationText = meetingStartTimeAndDuration.split(" ");
                String meetingStartDateString = startTimeAndDurationText[0]; // 2020-08-21
                String meetingStartTimeString = startTimeAndDurationText[1]; // 09:00
                String meetingDuration = startTimeAndDurationText[2]; // 2

                Date meetingStartDate = dateFormat.parse(meetingStartDateString);
                Date requestMeetingStartTimeAsDate = timeFormat.parse(meetingStartTimeString);

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(requestMeetingStartTimeAsDate);
                // Add duration to meeting start time
                calendar.add(Calendar.HOUR, Integer.parseInt(meetingDuration));
                Date requestMeetingEndTimeAsDate = calendar.getTime();

                // If request meeting time falls under the office timings
                if (isMatchWithOfficeTime(requestMeetingStartTimeAsDate, requestMeetingEndTimeAsDate)) {
                    String bookingInfo = requestSubmissionDateTimeString + " " + meetingStartDateString + " " + meetingStartTimeString + " "
                            + timeFormat.format(requestMeetingEndTimeAsDate) + " " + employeeId;
                    // Add it to bookings array list
                    allBookings.add(bookingInfo);
                }
            }

            // sort by date oldest on top
          Collections.sort(allBookings,Collections.reverseOrder());
            List<String> successfulBookings = new ArrayList<>();
            for (String booking : allBookings) {
                String[] bookingInfo = booking.split(" ");
                String bookingSlot = bookingInfo[2] + " \n" +  bookingInfo[3] + " " + bookingInfo[4] + " " + bookingInfo[5];
                // Convert to date format
                Date bookingSubmittedDateTime = dateTimeFormat.parse(bookingInfo[0] + " " + bookingInfo[1]);
                // If requestSubmissionDateTime is before the previous submission time
                if (isBeforePreviousSubmissions(bookingSubmittedDateTime)) {
                    if (!successfulBookings.contains(bookingSlot)) { // if it not contains in existing array then only add it and print
                        successfulBookings.add(bookingSlot);
                        System.out.println(bookingSlot); // Print the successful bookings as output
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isMatchWithOfficeTime(Date d1, Date d2) {
        return d1.getHours() >= fromOfficeTimeDate.getHours() && d2.getHours() <= toOfficeTimeDate.getHours();
    }

    private static boolean isBeforePreviousSubmissions(Date submissionDateTime) throws ParseException {
        for (String booking : allBookings) {
            String[] bookingInfo = booking.split(" ");
            Date bookingSubmittedDateTime = dateTimeFormat.parse(bookingInfo[0] + " " + bookingInfo[1]);
            if (submissionDateTime.before(bookingSubmittedDateTime)) {
                return true;
            }
        }
        return false;
    }
}

