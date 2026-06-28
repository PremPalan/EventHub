package com.ram.tickets.services;

import com.ram.tickets.domain.entities.TicketValidation;

import java.util.UUID;

public interface TicketValidationService {

    TicketValidation validateTicketIdByQrCode(UUID qrCodeId);

    TicketValidation validateTicketManually(UUID ticketId);
}
