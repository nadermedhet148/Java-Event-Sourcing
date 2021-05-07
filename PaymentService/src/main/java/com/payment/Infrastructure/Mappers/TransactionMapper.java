package com.payment.Infrastructure.Mappers;

import com.payment.Domain.Event.DomainEvent;
import com.payment.Infrastructure.Entites.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper( TransactionMapper.class );

    Transaction domainTransactionToTransaction( com.payment.Domain.Transaction.Transaction transaction);
}
