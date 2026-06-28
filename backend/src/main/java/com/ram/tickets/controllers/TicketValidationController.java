package com.ram.tickets.controllers;

import com.ram.tickets.domain.dtos.validations.TicketValidationRequestDto;
import com.ram.tickets.domain.dtos.validations.TicketValidationResponseDto;
import com.ram.tickets.domain.entities.TicketValidation;
import com.ram.tickets.domain.entities.TicketValidationMethod;
import com.ram.tickets.domain.entities.TicketValidationMethodEnum;
import com.ram.tickets.mappers.TicketValidationMapper;
import com.ram.tickets.services.TicketValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.ReplicateScaleFilter;

@RestController
@RequestMapping(path = "/api/v1/ticket-validations")
@RequiredArgsConstructor
public class TicketValidationController {

    private final TicketValidationService ticketValidationService;
    private final TicketValidationMapper ticketValidationMapper;

    @PostMapping
    public ResponseEntity<TicketValidationResponseDto> validateTicket(
            @RequestBody TicketValidationRequestDto ticketValidationRequestDto
            ){
        TicketValidationMethod method = ticketValidationRequestDto.getMethod();

        TicketValidation ticketValidation;

        if(TicketValidationMethod.MANUAL.equals(method)){
            ticketValidation = ticketValidationService.validateTicketManually(ticketValidationRequestDto.getId());
        }else {
            ticketValidation = ticketValidationService.validateTicketIdByQrCode(
                    ticketValidationRequestDto.getId()
            );
        }

        return ResponseEntity.ok(ticketValidationMapper.toTicketValidationResponseDto(ticketValidation));
    }

}
