package client.domain.response.chain.account;

import java.util.List;

public class RequiredAuth {

    private List<String> accounts;

    private List<Key> keys;

    private String threshold;

    public List<String> getAccounts ()
    {
        return accounts;
    }

    public void setAccounts (List<String>  accounts)
    {
        this.accounts = accounts;
    }

    public List<Key> getKeys ()
    {
        return keys;
    }

    public void setKeys (List<Key> keys)
    {
        this.keys = keys;
    }

    public String getThreshold ()
    {
        return threshold;
    }

    public void setThreshold (String threshold)
    {
        this.threshold = threshold;
    }
}
