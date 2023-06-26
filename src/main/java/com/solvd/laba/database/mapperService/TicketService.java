package com.solvd.laba.database.mapperService;

import com.solvd.laba.database.mapper.TicketMapper;
import com.solvd.laba.database.model.Ticket;
import org.apache.ibatis.session.SqlSessionFactory;

public class TicketService {
    private final TicketMapper ticketMapper;

    public TicketService(SqlSessionFactory sqlSessionFactory) {
        this.ticketMapper = sqlSessionFactory.openSession().getMapper(TicketMapper.class);
    }

    public Ticket getTicketById(int id) {
        return ticketMapper.selectTicketById(id);
    }

    public void setTicket(Ticket ticket) {
        ticketMapper.insertTicket(ticket);
    }

    public void updateTicket(Ticket ticket) {
        ticketMapper.updateTicket(ticket);
    }

    public void deleteTicketById(int id) {
        ticketMapper.deleteTicketById(id);
    }
}
