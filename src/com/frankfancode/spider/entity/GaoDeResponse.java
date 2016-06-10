package com.frankfancode.spider.entity;

import java.util.List;

/**
 * Created by Frank on 2016/6/10.
 */
public class GaoDeResponse {


    /**
     * count : 1
     * infocode : 10000
     * geocodes : [{"formatted_address":"北京市东城区天安门","city":"北京市","adcode":"110101","level":"兴趣点","building":{"name":[],"type":[]},"number":[],"province":"北京市","citycode":"010","street":[],"district":"东城区","location":"116.397846,39.900558","neighborhood":{"name":[],"type":[]},"township":[]}]
     * status : 1
     * info : OK
     */
    private String count;
    private String infocode;
    private List<GeocodesEntity> geocodes;
    private String status;
    private String info;

    public void setCount(String count) {
        this.count = count;
    }

    public void setInfocode(String infocode) {
        this.infocode = infocode;
    }

    public void setGeocodes(List<GeocodesEntity> geocodes) {
        this.geocodes = geocodes;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCount() {
        return count;
    }

    public String getInfocode() {
        return infocode;
    }

    public List<GeocodesEntity> getGeocodes() {
        return geocodes;
    }

    public String getStatus() {
        return status;
    }

    public String getInfo() {
        return info;
    }

    public class GeocodesEntity {
        /**
         * formatted_address : 北京市东城区天安门
         * city : 北京市
         * adcode : 110101
         * level : 兴趣点
         * building : {"name":[],"type":[]}
         * number : []
         * province : 北京市
         * citycode : 010
         * street : []
         * district : 东城区
         * location : 116.397846,39.900558
         * neighborhood : {"name":[],"type":[]}
         * township : []
         */
        private String formatted_address;
        private String city;
        private String adcode;
        private String level;
        private BuildingEntity building;
        private List<?> number;
        private String province;
        private String citycode;
        private List<?> street;
        private String district;
        private String location;
        private NeighborhoodEntity neighborhood;
        private List<?> township;

        public void setFormatted_address(String formatted_address) {
            this.formatted_address = formatted_address;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setAdcode(String adcode) {
            this.adcode = adcode;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public void setBuilding(BuildingEntity building) {
            this.building = building;
        }

        public void setNumber(List<?> number) {
            this.number = number;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public void setCitycode(String citycode) {
            this.citycode = citycode;
        }

        public void setStreet(List<?> street) {
            this.street = street;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public void setNeighborhood(NeighborhoodEntity neighborhood) {
            this.neighborhood = neighborhood;
        }

        public void setTownship(List<?> township) {
            this.township = township;
        }

        public String getFormatted_address() {
            return formatted_address;
        }

        public String getCity() {
            return city;
        }

        public String getAdcode() {
            return adcode;
        }

        public String getLevel() {
            return level;
        }

        public BuildingEntity getBuilding() {
            return building;
        }

        public List<?> getNumber() {
            return number;
        }

        public String getProvince() {
            return province;
        }

        public String getCitycode() {
            return citycode;
        }

        public List<?> getStreet() {
            return street;
        }

        public String getDistrict() {
            return district;
        }

        public String getLocation() {
            return location;
        }

        public NeighborhoodEntity getNeighborhood() {
            return neighborhood;
        }

        public List<?> getTownship() {
            return township;
        }

        public class BuildingEntity {
            /**
             * name : []
             * type : []
             */
            private List<?> name;
            private List<?> type;

            public void setName(List<?> name) {
                this.name = name;
            }

            public void setType(List<?> type) {
                this.type = type;
            }

            public List<?> getName() {
                return name;
            }

            public List<?> getType() {
                return type;
            }
        }

        public class NeighborhoodEntity {
            /**
             * name : []
             * type : []
             */
            private List<?> name;
            private List<?> type;

            public void setName(List<?> name) {
                this.name = name;
            }

            public void setType(List<?> type) {
                this.type = type;
            }

            public List<?> getName() {
                return name;
            }

            public List<?> getType() {
                return type;
            }
        }
    }
}
