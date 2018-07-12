package client.impl;


import client.domain.common.transaction.SignedPackedTransaction;
import client.domain.request.chain.AbiJsonToBinRequest;
import client.domain.request.chain.RequiredKeysRequest;
import client.domain.request.chain.transaction.PushBlockRequest;
import client.domain.request.chain.transaction.PushTransactionRequest;
import client.domain.request.wallet.transaction.SignTransactionRequest;
import client.domain.response.chain.*;
import client.domain.response.chain.account.Account;
import client.domain.response.chain.code.Code;
import client.domain.common.transaction.PackedTransaction;
import client.domain.response.chain.transaction.PushedTransaction;
import client.util.Utils;
import com.fasterxml.jackson.databind.JsonNode;


import java.util.*;

public class EosApiRestClientImpl implements EosApiRestClient {

    private final EosApiService eosApiService;

    public EosApiRestClientImpl(String baseUrl) {
        eosApiService = EosApiServiceGenerator.createService(EosApiService.class, baseUrl);
    }

    @Override
    public JsonNode getAbi(Map<String, String> requestField) {
        return EosApiServiceGenerator.executeSync(eosApiService.getAbi(requestField));
    }

    @Override
    public ChainInfo getChainInfo() {
        return EosApiServiceGenerator.executeSync(eosApiService.getChainInfo());
    }

    @Override
    public Block getBlock(String blockNumberOrId) {
        return EosApiServiceGenerator.executeSync(eosApiService.getBlock(Collections.singletonMap("block_num_or_id", blockNumberOrId)));
    }

    @Override
    public Account getAccount(String accountName) {
        return EosApiServiceGenerator.executeSync(eosApiService.getAccount(Collections.singletonMap("account_name", accountName)));
    }

    @Override
    public Code getCode(String accountName) {
        return EosApiServiceGenerator.executeSync(eosApiService.getCode(Collections.singletonMap("account_name", accountName)));
    }

    @Override
    public TableRow getTableRows(String scope, String code, String table) {
        LinkedHashMap<String, String> requestParameters = new LinkedHashMap<>(7);

        requestParameters.put("scope", scope);
        requestParameters.put("code", code);
        requestParameters.put("table", table);
        requestParameters.put("json", "true");

        return EosApiServiceGenerator.executeSync(eosApiService.getTableRows(requestParameters));
    }

    @Override
    public AbiBinToJson abiBinToJson(String code, String action, String binargs) {
        LinkedHashMap<String, String> requestParameters = new LinkedHashMap<>(3);

        requestParameters.put("code", code);
        requestParameters.put("action", action);
        requestParameters.put("binargs", binargs);

        return EosApiServiceGenerator.executeSync(eosApiService.abiBinToJson(requestParameters));
    }

    @Override
    public AbiJsonToBin abiJsonToBin(String code, String action, Map<String, String> args) {
        return EosApiServiceGenerator.executeSync(eosApiService.abiJsonToBin(new AbiJsonToBinRequest(code, action, args)));
    }

    @Override
    public PushedTransaction pushTransaction(String compression, SignedPackedTransaction packedTransaction) {
        PushTransactionRequest request = new PushTransactionRequest(compression, packedTransaction, packedTransaction.getSignatures());
        System.out.println(request);
        return EosApiServiceGenerator.executeSync(eosApiService.pushTransaction(request));
    }

    @Override
    public JsonNode pushTransaction(client.crypto.model.chain.PackedTransaction body) {
        return EosApiServiceGenerator.executeSync(eosApiService.pushTransaction(body));
    }

    @Override
    public List<PushedTransaction> pushTransactions(List<PushTransactionRequest> pushTransactionRequests) {
        return EosApiServiceGenerator.executeSync(eosApiService.pushTransactions(pushTransactionRequests));
    }

    @Override
    public RequiredKeys getRequiredKeys(PackedTransaction transaction, List<String> keys) {
        return EosApiServiceGenerator.executeSync(eosApiService.getRequiredKeys(new RequiredKeysRequest(transaction, keys)));
    }

    @Override
    public String createWallet(String walletName) {
        return EosApiServiceGenerator.executeSync(eosApiService.createWallet(walletName));
    }

    @Override
    public void openWallet(String walletName) {
        EosApiServiceGenerator.executeSync(eosApiService.openWallet(walletName));
    }

    @Override
    public void lockWallet(String walletName) {
        EosApiServiceGenerator.executeSync(eosApiService.lockWallet(walletName));
    }

    @Override
    public void lockAllWallets() {
        EosApiServiceGenerator.executeSync(eosApiService.lockAll());
    }

    @Override
    public void unlockWallet(String walletName, String walletPassword) {
        List<String> requestFields = new ArrayList<>(2);

        requestFields.add(walletName);
        requestFields.add(walletPassword);
        EosApiServiceGenerator.executeSync(eosApiService.unlockWallet(requestFields));
    }

    @Override
    public void importKeyIntoWallet(String walletName, String key) {
        List<String> requestFields = new ArrayList<>(2);

        requestFields.add(walletName);
        requestFields.add(key);
        EosApiServiceGenerator.executeSync(eosApiService.importKey(requestFields));
    }

    @Override
    public List<String> listWallets() {
        return EosApiServiceGenerator.executeSync(eosApiService.listWallets());
    }

    @Override
    public List<List<String>> listKeys() {
        return EosApiServiceGenerator.executeSync(eosApiService.listKeys());
    }

    @Override
    public List<String> getPublicKeys() {
        return EosApiServiceGenerator.executeSync(eosApiService.getPublicKeys());
    }

    @Override
    public SignedPackedTransaction signTransaction(PackedTransaction packedTransaction, List<String> publicKeys, String chainId) {
        SignTransactionRequest signTransactionRequest = new SignTransactionRequest(packedTransaction, publicKeys, chainId);
        System.out.println("peding signTransactionRequest : " + Utils.toJsonByGson(signTransactionRequest));
        return EosApiServiceGenerator.executeSync(eosApiService.signTransaction(signTransactionRequest));
    }

    @Override
    public void setWalletTimeout(Integer timeout) {
        EosApiServiceGenerator.executeSync(eosApiService.setTimeout(timeout));
    }

    @Override
    public void pushBlock(PushBlockRequest pushBlockRequest) {
        System.out.println(Utils.toJson(pushBlockRequest));
        EosApiServiceGenerator.executeSync(eosApiService.pushBlock(pushBlockRequest));
    }

}
