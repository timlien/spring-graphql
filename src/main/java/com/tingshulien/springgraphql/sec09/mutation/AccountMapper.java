package com.tingshulien.springgraphql.sec09.mutation;

public class AccountMapper {

  public static Account toEntity(AccountDto dto) {
    return Account.newInstance(dto.getId(), dto.getName(), dto.getAge());
  }

  public static AccountDto toDto(Account entity) {
    return AccountDto.newInstance(entity.getId(), entity.getName(), entity.getAge());
  }

}
