package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager ticketManager = new TicketManager(repository);
    Ticket firstTicket = new Ticket(1, 5465, "MOW", "KZN", 95);
    Ticket secondTicket = new Ticket(2, 4940, "DME", "KZN", 110);
    Ticket thirdTicket = new Ticket(3, 4660, "MOW", "KZN", 100);
    Ticket fourthTicket = new Ticket(4, 6620, "DME", "KZN", 125);
    Ticket fifthTicket = new Ticket(5, 7080, "SVO", "KZN", 105);

    @Test
    void shouldSortSomeTicketsWithDifferentPrice() {
        Ticket[] expected = new Ticket[] {thirdTicket, firstTicket};
        ticketManager.add(firstTicket);
        ticketManager.add(secondTicket);
        ticketManager.add(thirdTicket);
        ticketManager.add(fourthTicket);
        ticketManager.add(fifthTicket);

        Ticket[] actual = ticketManager.searchBy("MOW", "KZN");

        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindOneTicket() {
        Ticket[] expected = new Ticket[]{fifthTicket};
        ticketManager.add(firstTicket);
        ticketManager.add(secondTicket);
        ticketManager.add(thirdTicket);
        ticketManager.add(fourthTicket);
        ticketManager.add(fifthTicket);

        Ticket[] actual = ticketManager.searchBy("SVO", "KZN");
        assertArrayEquals(expected, actual);
    }
}