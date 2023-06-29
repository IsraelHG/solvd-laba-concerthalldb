package com.solvd.laba.database.service;

import com.solvd.laba.database.interfaces.IBookingService;
import com.solvd.laba.database.mapper.BookingMapper;
import com.solvd.laba.database.model.Booking;
import com.solvd.laba.database.mybatis.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;

public class BookingServiceMyBatis implements IBookingService {
    private final SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();

    public BookingServiceMyBatis() {}

    public Booking getBookingById(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BookingMapper bookingMapper = session.getMapper(BookingMapper.class);
            return bookingMapper.getBookingById(id);
        }
    }

    @Override
    public Booking getBookingByAudienceId(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BookingMapper bookingMapper = session.getMapper(BookingMapper.class);
            return bookingMapper.getBookingByAudienceId(id);
        }
    }

    public ArrayList<Booking> getBookings() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BookingMapper bookingMapper = session.getMapper(BookingMapper.class);
            return bookingMapper.getBookings();
        }
    }

    public void setBooking(Booking booking) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            BookingMapper bookingMapper = session.getMapper(BookingMapper.class);
            bookingMapper.insertBooking(booking);
        }
    }

    public void updateBooking(Booking booking) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            BookingMapper bookingMapper = session.getMapper(BookingMapper.class);
            bookingMapper.updateBooking(booking);
        }
    }

    public void deleteBooking(Booking booking) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            BookingMapper bookingMapper = session.getMapper(BookingMapper.class);
            bookingMapper.deleteBooking(booking);
        }
    }
}
