package com.live.model;

/**
 * 开启
 */
public class StartLiveBean {

    /**
     * errno : 0
     * errmsg :
     * data : {"id":"1","owner":"85323a42-ae1c-4901-b3ac-0b513e3964d7","title":"直播","push_url":"rtmp://livepush.cdwan.cn/shop/85323a42-ae1c-4901-b3ac-0b513e3964d7?txSecret=b5efec0323c0fbfc92bdf3f5fcd2a55a&txTime=5ff487a0","play_url":"rtmp://live.cdwan.cn/shop/85323a42-ae1c-4901-b3ac-0b513e3964d7?txSecret=b5efec0323c0fbfc92bdf3f5fcd2a55a&txTime=5ff487a0","status":1}
     */

    private int errno;
    private String errmsg;
    private DataBean data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * owner : 85323a42-ae1c-4901-b3ac-0b513e3964d7
         * title : 直播
         * push_url : rtmp://livepush.cdwan.cn/shop/85323a42-ae1c-4901-b3ac-0b513e3964d7?txSecret=b5efec0323c0fbfc92bdf3f5fcd2a55a&txTime=5ff487a0
         * play_url : rtmp://live.cdwan.cn/shop/85323a42-ae1c-4901-b3ac-0b513e3964d7?txSecret=b5efec0323c0fbfc92bdf3f5fcd2a55a&txTime=5ff487a0
         * status : 1
         */

        private String id;
        private String owner;
        private String title;
        private String push_url;
        private String play_url;
        private int status;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPush_url() {
            return push_url;
        }

        public void setPush_url(String push_url) {
            this.push_url = push_url;
        }

        public String getPlay_url() {
            return play_url;
        }

        public void setPlay_url(String play_url) {
            this.play_url = play_url;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
