package com.live.model;

public class LiveUrlBean {

    /**
     * errno : 0
     * errmsg :
     * data : {"id":1,"name":"666的房间","icon":"https://shop-app1.oss-cn-beijing.aliyuncs.com/live/1/room.jpg","owner":"85323a42-ae1c-4901-b3ac-0b513e3964d7","push_url":"rtmp://livepush.cdwan.cn/shop/85323a42-ae1c-4901-b3ac-0b513e3964d7?txSecret=b5efec0323c0fbfc92bdf3f5fcd2a55a&txTime=5ff487a0","play_url":"rtmp://live.cdwan.cn/shop/85323a42-ae1c-4901-b3ac-0b513e3964d7?txSecret=b5efec0323c0fbfc92bdf3f5fcd2a55a&txTime=5ff487a0","isopen":1,"status":1}
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
         * name : 666的房间
         * icon : https://shop-app1.oss-cn-beijing.aliyuncs.com/live/1/room.jpg
         * owner : 85323a42-ae1c-4901-b3ac-0b513e3964d7
         * push_url : rtmp://livepush.cdwan.cn/shop/85323a42-ae1c-4901-b3ac-0b513e3964d7?txSecret=b5efec0323c0fbfc92bdf3f5fcd2a55a&txTime=5ff487a0
         * play_url : rtmp://live.cdwan.cn/shop/85323a42-ae1c-4901-b3ac-0b513e3964d7?txSecret=b5efec0323c0fbfc92bdf3f5fcd2a55a&txTime=5ff487a0
         * isopen : 1
         * status : 1
         */

        private int id;
        private String name;
        private String icon;
        private String owner;
        private String play_url;
        private int isopen;
        private int status;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getPlay_url() {
            return play_url;
        }

        public void setPlay_url(String play_url) {
            this.play_url = play_url;
        }

        public int getIsopen() {
            return isopen;
        }

        public void setIsopen(int isopen) {
            this.isopen = isopen;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
