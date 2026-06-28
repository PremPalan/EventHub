package com.ram.tickets.mappers;

import com.ram.tickets.domain.CreateEventRequest;
import com.ram.tickets.domain.CreateTicketTypeRequest;
import com.ram.tickets.domain.UpdateEventRequest;
import com.ram.tickets.domain.UpdateTicketTypeRequest;
import com.ram.tickets.domain.dtos.create.CreateEventRequestDto;
import com.ram.tickets.domain.dtos.create.CreateEventResponseDto;
import com.ram.tickets.domain.dtos.create.CreateTicketTypeRequestDto;
import com.ram.tickets.domain.dtos.get.get.GetEventDetailsResponseDto;
import com.ram.tickets.domain.dtos.get.get.GetEventDetailsTicketTypesResponseDto;
import com.ram.tickets.domain.dtos.get.get.GetPublishedEventDetailsResponseDto;
import com.ram.tickets.domain.dtos.get.get.GetPublishedEventDetailsTicketTypesResponseDto;
import com.ram.tickets.domain.dtos.get.list.ListEventResponseDto;
import com.ram.tickets.domain.dtos.get.list.ListEventTicketTypeResponseDto;
import com.ram.tickets.domain.dtos.get.list.ListPublishedEventResponseDto;
import com.ram.tickets.domain.dtos.update.UpdateEventRequestDto;
import com.ram.tickets.domain.dtos.update.UpdateEventResponseDto;
import com.ram.tickets.domain.dtos.update.UpdateTicketTypeRequestDto;
import com.ram.tickets.domain.dtos.update.UpdateTicketTypeResponseDto;
import com.ram.tickets.domain.entities.Event;
import com.ram.tickets.domain.entities.TicketType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {
    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

    CreateEventRequest fromDto(CreateEventRequestDto dto);

    CreateEventResponseDto toDto(Event event);

    ListEventTicketTypeResponseDto toDto(TicketType ticketType);

    ListEventResponseDto toListEventResponseDto(Event event);

    GetEventDetailsTicketTypesResponseDto toGetEventDetailsTicketTypesResponseDto(TicketType type);

    GetEventDetailsResponseDto toGetEventDetailsResponseDto(Event event);

    UpdateTicketTypeRequest fromDto(UpdateTicketTypeRequestDto dto);

    UpdateEventRequest fromDto(UpdateEventRequestDto dto);

    UpdateTicketTypeResponseDto toUpdateTicketTypeResponseDto(TicketType ticketType);

    UpdateEventResponseDto toUpdateEventResponseDto(Event event);

    ListPublishedEventResponseDto toListPublishedEventResponseDto(Event event);

    GetPublishedEventDetailsResponseDto toGetPublishedEventDetailsResponseDto(Event event);

    GetPublishedEventDetailsTicketTypesResponseDto toGetPublishedEventDetailsTicketTypesResponseDto(TicketType ticketType);
}
