package client.impl;

import client.domain.common.transaction.SignedPackedTransaction;
import client.domain.request.chain.transaction.PushBlockRequest;
import client.domain.request.chain.transaction.PushTransactionRequest;
import client.domain.response.chain.*;
import client.domain.response.chain.account.Account;
import client.domain.response.chain.code.Code;
import client.domain.common.transaction.PackedTransaction;
import client.domain.response.chain.transaction.PushedTransaction;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
import java.util.Map;

public interface EosApiRestClient {

    JsonNode getAbi(Map<String, String> requestField);

    ChainInfo getChainInfo();

    Block getBlock(String blockNumberOrId);

    Account getAccount(String accountName);

    Code getCode(String accountName);

    TableRow getTableRows(String scope, String code, String table);

    AbiBinToJson abiBinToJson(String code, String action, String binargs);

    AbiJsonToBin abiJsonToBin(String code, String action, Map<String, String> args);

    PushedTransaction pushTransaction(String compression, SignedPackedTransaction packedTransaction);

    public JsonNode pushTransaction(client.crypto.model.chain.PackedTransaction body);

    List<PushedTransaction> pushTransactions(List<PushTransactionRequest> pushTransactionRequests);

    RequiredKeys getRequiredKeys(PackedTransaction transaction, List<String> keys);

    String createWallet(String walletName);

    void openWallet(String walletName);

    void lockWallet(String walletName);

    void lockAllWallets();

    void unlockWallet(String walletName, String walletPassword);

    void importKeyIntoWallet(String walletName, String walletKey);

    List<String> listWallets();

    List<List<String>> listKeys();

    List<String> getPublicKeys();

    SignedPackedTransaction signTransaction(PackedTransaction unsignedTransaction, List<String> publicKeys, String chainId);

    void setWalletTimeout(Integer timeout);

    void pushBlock(PushBlockRequest pushBlockRequest);
}
