package com.Flight_Reservation_App1.util;
import java.io.FileOutputStream;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.Flight_Reservation_App1.Entity.Flight;
import com.Flight_Reservation_App1.Entity.Reservation;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
@Component
public class PdfGenerator {
	 
    public  void generateItinerary(Reservation reservation,String filePath,String date,String time) {
    	 Document document = new Document();
    	try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            document.add(generateTable(reservation, date, time));
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private PdfPTable generateTable(Reservation reservation,String date,String time){
        PdfPTable table = new PdfPTable(2);
        PdfPCell cell;
        cell=new PdfPCell(new Phrase("Flight Itinerary"));
        cell.setColspan(2);
        table.addCell(cell);
        
        cell=new PdfPCell(new Phrase("Flight Details"));
        cell.setColspan(2);
        table.addCell(cell);
        
        table.addCell("Departure City");
        table.addCell(reservation.getFlight().getDepartureCity());
        
        table.addCell("Arrival City");
        table.addCell(reservation.getFlight().getArrivalCity());
        
        table.addCell("Flight Number");
        table.addCell(reservation.getFlight().getFlightNumber());
        
        table.addCell("Operationg Airline");
        table.addCell(reservation.getFlight().getOperatingAirline());
        
        table.addCell("Departure Date");
        table.addCell(date);
        
        table.addCell("Departure time");
        table.addCell(time);
       
        cell=new PdfPCell(new Phrase("Passenger Detail"));
        cell.setColspan(2);
        table.addCell(cell);
        
        table.addCell("First Name");
        table.addCell(reservation.getPassenger().getFirstName());
        
        table.addCell("Last Name");
        table.addCell(reservation.getPassenger().getLastName());
        
        table.addCell("Email");
        table.addCell(reservation.getPassenger().getEmail());
        
        table.addCell("Mobile Number");
        table.addCell(reservation.getPassenger().getPhoneNo());
        
       return table;
    }

  
}
