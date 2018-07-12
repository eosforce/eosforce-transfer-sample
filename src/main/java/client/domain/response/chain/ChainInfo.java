package client.domain.response.chain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChainInfo {

    private String serverVersion;

    private String headBlockNum;

    private String lastIrreversibleBlockNum;

    private String lastIrreversibleBlockid;

    private String headBlockId;

    private String headBlockTime;

    private String headBlockProducer;

    private String recentSlots;

    private String participationRate;

    private String chainId;

    private String virtualBlockCpuLimit;

    private String virtualBlockNetLimit;

    private String blockCpuLimit;

    private String blockNetLimit;

    public ChainInfo() {

    }

    public String getVirtualBlockCpuLimit() {
        return virtualBlockCpuLimit;
    }

    @JsonProperty("virtual_block_cpu_limit")
    public void setVirtualBlockCpuLimit(String virtualBlockCpuLimit) {
        this.virtualBlockCpuLimit = virtualBlockCpuLimit;
    }

    public String getVirtualBlockNetLimit() {
        return virtualBlockNetLimit;
    }

    @JsonProperty("virtual_block_net_limit")
    public void setVirtualBlockNetLimit(String virtualBlockNetLimit) {
        this.virtualBlockNetLimit = virtualBlockNetLimit;
    }

    public String getBlockCpuLimit() {
        return blockCpuLimit;
    }

    @JsonProperty("block_cpu_limit")
    public void setBlockCpuLimit(String blockCpuLimit) {
        this.blockCpuLimit = blockCpuLimit;
    }

    public String getBlockNetLimit() {
        return blockNetLimit;
    }

    @JsonProperty("block_net_limit")
    public void setBlockNetLimit(String blockNetLimit) {
        this.blockNetLimit = blockNetLimit;
    }

    public String getChainId() {
        return chainId;
    }

    public String getLastIrreversibleBlockid() {
        return lastIrreversibleBlockid;
    }

    @JsonProperty("last_irreversible_block_id")
    public void setLastIrreversibleBlockid(String lastIrreversibleBlockid) {
        this.lastIrreversibleBlockid = lastIrreversibleBlockid;
    }

    @JsonProperty("chain_id")
    public void setChainId(String chainId) {
        this.chainId = chainId;
    }

    public String getServerVersion() {
        return serverVersion;
    }

    @JsonProperty("server_version")
    public void setServerVersion(String serverVersion) {
        this.serverVersion = serverVersion;
    }

    public String getHeadBlockNum() {
        return headBlockNum;
    }

    @JsonProperty("head_block_num")
    public void setHeadBlockNum(String headBlockNum) {
        this.headBlockNum = headBlockNum;
    }

    public String getLastIrreversibleBlockNum() {
        return lastIrreversibleBlockNum;
    }

    @JsonProperty("last_irreversible_block_num")
    public void setLastIrreversibleBlockNum(String lastIrreversibleBlockNum) {
        this.lastIrreversibleBlockNum = lastIrreversibleBlockNum;
    }

    public String getHeadBlockId() {
        return headBlockId;
    }

    @JsonProperty("head_block_id")
    public void setHeadBlockId(String headBlockId) {
        this.headBlockId = headBlockId;
    }

    public String getHeadBlockTime() {
        return headBlockTime;
    }

    @JsonProperty("head_block_time")
    public void setHeadBlockTime(String headBlockTime) {
        this.headBlockTime = headBlockTime;
    }

    public String getHeadBlockProducer() {
        return headBlockProducer;
    }

    @JsonProperty("head_block_producer")
    public void setHeadBlockProducer(String headBlockProducer) {
        this.headBlockProducer = headBlockProducer;
    }

    public String getParticipationRate() {
        return participationRate;
    }

    @JsonProperty("participation_rate")
    public void setParticipationRate(String participationRate) {
        this.participationRate = participationRate;
    }

    public String getRecentSlots() {
        return recentSlots;
    }

    @JsonProperty("recent_slots")
    public void setRecentSlots(String recentSlots) {
        this.recentSlots = recentSlots;
    }
}
