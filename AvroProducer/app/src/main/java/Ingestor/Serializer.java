package Ingestor;

import java.io.File;
import java.io.IOException;

import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;

import com.gap.Event;

import co.uk.dalelane.Compass;
import co.uk.dalelane.Type3;
import my.example.mailing_address;
import my.example.userInfo;

public class Serializer {
	public static void main(String[] args) throws IOException {
		Event e = new Event();
		e.setPromotionId("AB1C123");
		e.setType("personalized");
		e.setValidFor(30);
		e.setTest2(1);
		
		
		Event e3 = Event.newBuilder()
	             .setPromotionId("CYOSD")
	     		 .setType("Stores")
	     		 .setValidFor(10)
	     		 .setTest2(1)
	             .build();
	
		DatumWriter<Event> eventDatumWriter = new SpecificDatumWriter<Event>(Event.class);
		DataFileWriter<Event> dataFileWriter = new DataFileWriter<Event>(eventDatumWriter);
		dataFileWriter.create(e.getSchema(), new File("events.avro"));
		dataFileWriter.append(e);
		dataFileWriter.append(e3);
		dataFileWriter.close();
		
		
		
		//example1
		Type3 t = new Type3();
		t.setDirection(Compass.EAST);
		
		Type3 t2 = new Type3();
		t2.setDirection(Compass.WEST);
		DatumWriter<Type3> eventDatumWriter2 = new SpecificDatumWriter<Type3>(Type3.class);
		DataFileWriter<Type3> dataFileWriter2 = new DataFileWriter<Type3>(eventDatumWriter2);
		dataFileWriter2.create(t.getSchema(), new File("Type3.avro"));
		dataFileWriter2.append(t);
		dataFileWriter2.append(t2);
		dataFileWriter2.close();
		

		userInfo ui = new userInfo();
		ui.setAge(12);
		ui.setHousenum("421");
		ui.setPhone("1234");
		ui.setUsername("afvcs_adas");
		mailing_address ma = new mailing_address();
		ma.setCity("SF");
		ma.setCountry("US");
		ma.setStateProv("CA");
		ma.setStreet("folsom st");
		ma.setZip("94530");
		
		ui.setAddress(ma);
		
		userInfo u2 = new userInfo();
		u2.setAge(15);
		u2.setHousenum("421");
		u2.setPhone("4321");
		u2.setUsername("qafvcs_adas");
		
		ma = new mailing_address();
		ma.setCity("SF");
		ma.setCountry("CANADA");
		ma.setStateProv("ALABANA");
		ma.setStreet("folsom st");
		ma.setZip("34530");
		u2.setAddress(ma);
		
		DatumWriter<userInfo> eventDatumWriter3 = new SpecificDatumWriter<userInfo>(userInfo.class);
		DataFileWriter<userInfo> dataFileWriter3 = new DataFileWriter<userInfo>(eventDatumWriter3);
		dataFileWriter3.create(ui.getSchema(), new File("userinfo.avro"));
		dataFileWriter3.append(ui);
		dataFileWriter3.append(u2);
		dataFileWriter3.close();
		
		

	}
	



}
