package com.solvd.laba.database.service;

import com.solvd.laba.database.interfaces.ITicketService;
import com.solvd.laba.database.mapper.TicketMapper;
import com.solvd.laba.database.model.Ticket;
import com.solvd.laba.database.mybatis.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;

public class TicketServiceMyBatis implements ITicketService {
    private final SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();

    public TicketServiceMyBatis() {}

    public Ticket getTicketById(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            TicketMapper ticketMapper = session.getMapper(TicketMapper.class);
            return ticketMapper.getTicketById(id);
        }
    }

    public ArrayList<Ticket> getTickets() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            TicketMapper ticketMapper = session.getMapper(TicketMapper.class);
            return ticketMapper.getTickets();
        }
    }

    public void setTicket(Ticket ticket) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            TicketMapper ticketMapper = session.getMapper(TicketMapper.class);
            ticketMapper.insertTicket(ticket);
        }
    }

    public void updateTicket(Ticket ticket) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            TicketMapper ticketMapper = session.getMapper(TicketMapper.class);
            ticketMapper.updateTicket(ticket);
        }
    }

    public void deleteTicket(Ticket ticket) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            TicketMapper ticketMapper = session.getMapper(TicketMapper.class);
            ticketMapper.deleteTicket(ticket);
        }
    }
}
