package com.tingshulien.springgraphql.sec09.mutation;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

  private final AccountRepository accountRepository;

  public List<AccountDto> allUsers() {
    return accountRepository.findAll().stream()
        .map(AccountMapper::toDto)
        .toList();
  }

  public AccountDto userById(Integer id) {
    return accountRepository.findById(id)
        .map(AccountMapper::toDto)
        .orElse(null);
  }

  public AccountDto createUser(AccountDto accountDto) {
    var user = AccountMapper.toEntity(accountDto);
    return AccountMapper.toDto(accountRepository.save(user));
  }

  public AccountDto updateUser(Integer id, AccountDto accountDto) {
    var userOptional = accountRepository.findById(id);
    if (userOptional.isEmpty()) {
      return null;
    }

    var user = AccountMapper.toEntity(accountDto);
    user.setId(id);
    return AccountMapper.toDto(accountRepository.save(user));
  }

  public DeleteResponseDto deleteUser(Integer id) {
    var userOptional = accountRepository.findById(id);
    if (userOptional.isEmpty()) {
      return DeleteResponseDto.newInstance(id, Status.FAILURE);
    }

    var user = userOptional.get();
    accountRepository.deleteById(user.getId());
    return DeleteResponseDto.newInstance(user.getId(), Status.SUCCESS);
  }

}
