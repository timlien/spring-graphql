package com.tingshulien.springgraphql.sec09.mutation;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AccountController {

  private final AccountService accountService;

  /**
   * Query example: { accounts { id name age } }
   *
   * @return all users
   */
  @QueryMapping
  public List<AccountDto> accounts() {
    return accountService.allUsers();
  }

  /**
   * Query example: { accountById(id: "2") { id name age } }
   *
   * @param id user id
   * @return user
   */
  @QueryMapping
  public AccountDto accountById(@Argument Integer id) {
    return accountService.userById(id);
  }

  /**
   * Query example: mutation CreateAccount($account: AccountDto!) { createAccount(accountDto:
   * $account) { id name age } }
   * <p>
   * Variable: { "account" : { "name": "Tim Lien", "age": 50 } }
   *
   * @param accountDto user
   * @return created user
   */
  @MutationMapping
  public AccountDto createAccount(@Argument AccountDto accountDto) {
    return accountService.createUser(accountDto);
  }

  /**
   * Query example: mutation UpdateAccount($id: ID!, $account: AccountDto!) { updateAccount(id: $id,
   * accountDto: $account) { id name age } }
   * <p>
   * Variable: { "id": 1, "account": { "name": "Tim Lien", "age": 50 } }
   *
   * @param id         user id
   * @param accountDto user
   * @return updated user
   */
  @MutationMapping
  public AccountDto updateAccount(@Argument Integer id, @Argument AccountDto accountDto) {
    return accountService.updateUser(id, accountDto);
  }

  /**
   * Query example: mutation DeleteAccount($id : ID!) { deleteAccount(id: $id) { id status } }
   * <p>
   * Variable: { "id": 2 }
   *
   * @param id user id
   * @return delete response
   */
  @MutationMapping
  public DeleteResponseDto deleteAccount(@Argument Integer id) {
    return accountService.deleteUser(id);
  }

}
