package com.bm.https.accessToken;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(description  = "公积金测试改造接口类")
@RestController
@RequestMapping("/api/gjj")
public class HttpsControllers {

    private Logger logger = LoggerFactory.getLogger(HttpsControllers.class);

    @ApiOperation(value = "测试连通性" ,  notes="返回参数")
    @RequestMapping(value = "/getCRMTest1",method = {RequestMethod.POST})
    public String getHttpTest(@RequestParam(value = "cxlb",required = false)String name,@RequestParam("dwxx")String numer){
        Map map  = new HashMap<>();
        map.put("cxlb",name);
        map.put("dwxx",numer);
        String param = JSONObject.toJSONString(map);
        try{
            logger.info("come in===="+param);
        }catch (Exception e){
            logger.error("come in===="+param);
        }

        return param;
    }

    @ApiOperation(value = "公积金单位信息查询接口" )
    @RequestMapping(value = "/getCRM",method = {RequestMethod.POST})
    public String getGJJS(@RequestParam("cxlb")String name,@RequestParam("dwxx")String numer){
        Map map  = new HashMap<>();
        map.put("cxlb",name);
        map.put("dwxx",numer);
        String param = JSONObject.toJSONString(map);
        logger.info("公积金接口请求单位信息查询====方法名：getGJJS=======入参："+param);
        try{
            String url = "https://59.207.236.40:443/CRM/jcdw/jcdwkhxxcx.service";
            logger.info("公积金接口请求单位信息查询====方法名：getGJJS=======请求url："+url);
            String string = com.bm.https.untils.HttpsUtilsZS.getServiceNetworkInformation(param, url);
            logger.info("公积金接口请求单位信息查询====方法名：getGJJS=======返回值："+string);
            return string;
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            return "error:"+param;
        }
    }
    @ApiOperation(value = "公积金个人信息查询接口" )
    @RequestMapping(value = "/getGJTQCX",method = {RequestMethod.POST})
    public String getGJTQCX(@RequestParam("zjhm")String name,@RequestParam("zxbm")String numer){
        Map map  = new HashMap<>();
        map.put("zjhm",name);
        map.put("zxbm",numer);
        String param = JSONObject.toJSONString(map);
        logger.info("公积金接口请求个人信息查询====方法名：getGJTQCX=======入参："+param);
        try{
            String url = "https://59.207.236.40:443/GJTQCX/jcrcx/jcrxxcx.service";
            logger.info("公积金接口请求个人信息查询====方法名：getGJTQCX=======请求url："+url);
            String string = com.bm.https.untils.HttpsUtilsZS.getServiceNetworkInformation(param, url);
            logger.info("公积金接口请求个人信息查询====方法名：getGJTQCX=======返回值："+string);
            return string;
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            return "error:"+param;
        }
    }

    @ApiOperation(value = "个人业务明细信息")
    @RequestMapping(value = "/GJTQCXZHMX",method = {RequestMethod.POST})
    public String getGJTQCXZHMX(@RequestParam(value = "blqd",required = false)String blqd,@RequestParam(value = "ywbm",required = false)String ywbm,
                               @RequestParam(value = "zxbm",required = false)String zxbm,
                               @RequestParam(value = "grxx",required = false)String grxx,
                                @RequestParam(value = "ksrq",required = false)String ksrq,@RequestParam(value = "jsrq",required = false)String jsrq,
                                @RequestParam(value = "jgbm",required = false)String jgbm,@RequestParam(value = "page",required = false)String page,
                                @RequestParam(value = "size",required = false)String size){
        Map map  = new HashMap<>();
        map.put("blqd",blqd);
        map.put("ywbm",ywbm);
        map.put("userid","1");
        map.put("zxbm",zxbm);
        map.put("dwzh"," ");
        map.put("grxx",grxx);
        map.put("ksrq",ksrq);
        map.put("jsrq",jsrq);
        map.put("jgbm",jgbm);
        map.put("page",page);
        map.put("size",size);
        String param = JSONObject.toJSONString(map);
        logger.info("公积金接口请求个人业务明细信息====方法名：getGJTQCXZHMX=======入参："+param);
        try{
            String url = "https://59.207.236.40:443/GJTQCX/jcrcx/jcrxxcxzhmx.service";
            logger.info("公积金接口请求个人业务明细信息====方法名：getGJTQCXZHMX=======请求url："+url);
            String string = com.bm.https.untils.HttpsUtilsZS.getServiceNetworkInformation(param, url);
            logger.info("公积金接口请求个人业务明细信息====方法名：getGJTQCXZHMX=======返回值："+string);
            return string;
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            return "error:"+param;
        }
    }

    @ApiOperation(value = "个人住房贷款借款合同信息")
    @RequestMapping(value = "/getDKSL",method = {RequestMethod.POST})
    public String getDKSL(@RequestParam(value = "jkrzjh",required = false)String jkrzjh,@RequestParam(value = "jkthbh",required = false)String jkthbh,@RequestParam(value = "dksfsp",required = false)String dksfsp,@RequestParam(value = "ywlch",required = false)String ywlch){
        Map map  = new HashMap<>();
        map.put("jkrzjh",jkrzjh);
        map.put("jkthbh",jkthbh);
        map.put("dksfsp",dksfsp);
        map.put("ywlch",ywlch);
        String param = JSONObject.toJSONString(map);
        logger.info("公积金接口请求个人住房贷款借款合同信息====方法名：getDKSL=======入参："+param);
        try{
            String url = "https://59.207.236.40:443/DKSL/dksq/dkhtxxcxNew.service";
            logger.info("公积金接口请求个人住房贷款借款合同信息====方法名：getDKSL=======请求url："+url);
            String string = com.bm.https.untils.HttpsUtilsZS.getServiceNetworkInformation(param, url);
            logger.info("公积金接口请求个人住房贷款借款合同信息====方法名：getDKSL=======返回值："+string);
            return string;
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            return "error:"+param;
        }
    }

    @ApiOperation(value = "共同借款人信息")
    @RequestMapping(value = "/getDHGL",method = {RequestMethod.POST})
    public String getDHGL(@RequestParam(value = "jkhtbh",required = false)String jkhtbh,@RequestParam(value = "zjhm",required = false) String zjhm){
        Map map  = new HashMap<>();
        map.put("jkhtbh",jkhtbh);
        map.put("zjhm",zjhm);
        String param = JSONObject.toJSONString(map);
        logger.info("公积金接口请求共同借款人信息====方法名：getDHGL=======入参："+param);
        try{
            String url = "https://59.207.236.40:443/DHGL/htbg/gtgrjkrbgxxcx.service";
            logger.info("公积金接口请求共同借款人信息====方法名：getDHGL=======请求url："+url);
            String string = com.bm.https.untils.HttpsUtilsZS.getServiceNetworkInformation(param, url);
            logger.info("公积金接口请求共同借款人信息====方法名：getDHGL=======返回值："+string);
            return string;
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            return "error:"+param;
        }
    }


    @ApiOperation(value = "个人住房贷款账户信息")
    @RequestMapping(value = "/getGRDKCX",method = {RequestMethod.POST})
    public String getGRDKCX(@RequestParam(value = "jkrzjh",required = false)String jkrzjh){

        /**
         * {"zxbm":"01","jgbm":" ","ywbm":"%","khbh":" ","zhbh":" ","blqd":"zxb","userid":"2","swtyhbm":"%","dysflr":"全部",
         * "jkhtbh_begin":"","fxdj":" ","jkrzjh":"412823198009101709","dkzt":"02","kfsmc":" ","htrq_begin":"","htrq_end":"","ffrq_begin":"",
         * "ffrq_end":"","jqrq_begin":"","jqrq_end":"","dwzh":" ","jkrdwmc":" ","dkje_begin":"0","dkje_end":"100",
         * "dknx_begin":"0","dknx_end":"60","qzlrrq_begin":"","qzlrrq_end":"","dkhkfs":"全部","dkdblx":"全部","xmmc":" ",
         * "fwxz":" ","zfmj_begin":"0","zfmj_end":"9999","gflx":"全部","fwzj_begin":"0","fwzj_end":"9999","sfydc":" ",
         * "posfgjjjk":" ","yqts":"0","sfyddkh":" ","dah":" ","page":"1","size":"999","sfcdy":"2"}
         */
        Map map  = new HashMap<>();
        map.put("zxbm","");map.put("jgbm","");map.put("ywbm","");map.put("khbh","");map.put("zhbh","");
        map.put("blqd","");map.put("userid","");map.put("swtyhbm","");map.put("dysflr","");map.put("jkhtbh_begin","");
        map.put("fxdj","");map.put("dkje_begin","");map.put("dkje_end","100");map.put("dknx_begin","");map.put("dknx_end","30");
        map.put("qzlrrq_begin","");map.put("qzlrrq_end","");map.put("dkhkfs","");map.put("fwzj_end","9999");map.put("posfgjjjk","");
        map.put("sfyddkh"," ");map.put("page","1");map.put("sfcdy","");map.put("jkrzjh",jkrzjh);map.put("dkzt","");
        map.put("kfsmc","");map.put("htrq_begin","");map.put("htrq_end","");map.put("ffrq_begin","");map.put("ffrq_end","");
        map.put("jqrq_begin","");map.put("jqrq_end","");map.put("dwzh","");map.put("jkrdwmc","");map.put("dkdblx","");
        map.put("xmmc","");map.put("fwxz","");map.put("zfmj_begin","");map.put("zfmj_end","9999");map.put("gflx","");
        map.put("fwzj_begin","");map.put("sfydc","");map.put("dah","");map.put("yqts","");map.put("size","100");

        String param = JSONObject.toJSONString(map);
        logger.info("公积金接口请求个人住房贷款账户信息====方法名：getGRDKCX=======入参："+param);
        try{
            String url = "https://59.207.236.40:443/GRDKCX/grdkyw/jkrzhcx1.service";
            logger.info("公积金接口请求个人住房贷款账户信息====方法名：getGRDKCX1=======请求url："+url);
            String string = com.bm.https.untils.HttpsUtilsZS.getServiceNetworkInformation(param, url);
            logger.info("公积金接口请求个人住房贷款账户信息====方法名：getGRDKCX1=======返回值："+string);
            return string;
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            return "error:"+param;
        }
    }

    @ApiOperation(value = "个人住房贷款账户信息old")
    @RequestMapping(value = "/getGRDKCX1",method = {RequestMethod.POST})
    public String getGRDKCX1(@RequestParam(value = "zxbm",required = false)String zxbm,@RequestParam(value = "jkrzjh",required = false)String jkrzjh,
                             @RequestParam(value = "jgbm",required = false)String jgbm,@RequestParam(value = "dkzt",required = false)String dkzt,
                             @RequestParam(value = "ywbm",required = false)String ywbm,@RequestParam(value = "kfsmc",required = false)String kfsmc,
                             @RequestParam(value = "khbh",required = false)String khbh,@RequestParam(value = "htrq_begin",required = false)String htrq_begin,
                             @RequestParam(value = "zhbh",required = false)String zhbh,@RequestParam(value = "htrq_end",required = false)String htrq_end,
                             @RequestParam(value = "blqd",required = false)String blqd,@RequestParam(value = "ffrq_begin",required = false)String ffrq_begin,
                             @RequestParam(value = "userid",required = false)String userid,@RequestParam(value = "ffrq_end",required = false)String ffrq_end,
                             @RequestParam(value = "swtyhbm",required = false)String swtyhbm,@RequestParam(value = "jqrq_begin",required = false)String jqrq_begin,
                             @RequestParam(value = "dysflr",required = false)String dysflr,@RequestParam(value = "jqrq_end",required = false)String jqrq_end,
                             @RequestParam(value = "jkhtbh_begin",required = false)String jkhtbh_begin,@RequestParam(value = "dwzh",required = false)String dwzh,
                             @RequestParam(value = "fxdj",required = false)String fxdj,@RequestParam(value = "jkrdwmc",required = false)String jkrdwmc,
                             @RequestParam(value = "dkje_begin",required = false)String dkje_begin,@RequestParam(value = "dkdblx",required = false)String dkdblx,
                             @RequestParam(value = "dkje_end",required = false)String dkje_end,@RequestParam(value = "xmmc",required = false)String xmmc,
                             @RequestParam(value = "dknx_begin",required = false)String dknx_begin,@RequestParam(value = "fwxz",required = false)String fwxz,
                             @RequestParam(value = "dknx_end",required = false)String dknx_end,@RequestParam(value = "zfmj_begin",required = false)String zfmj_begin,
                             @RequestParam(value = "qzlrrq_begin",required = false)String qzlrrq_begin,@RequestParam(value = "zfmj_end",required = false)String zfmj_end,
                             @RequestParam(value = "qzlrrq_end",required = false)String qzlrrq_end,@RequestParam(value = "gflx",required = false)String gflx,
                             @RequestParam(value = "dkhkfs",required = false)String dkhkfs,@RequestParam(value = "fwzj_begin",required = false)String fwzj_begin,
                             @RequestParam(value = "fwzj_end",required = false)String fwzj_end,@RequestParam(value = "sfydc",required = false)String sfydc,
                             @RequestParam(value = "posfgjjjk",required = false)String posfgjjjk,@RequestParam(value = "yqts",required = false)String yqts,
                             @RequestParam(value = "sfyddkh",required = false)String sfyddkh,@RequestParam(value = "dah",required = false)String dah,
                             @RequestParam(value = "page",required = false)String page,@RequestParam(value = "size",required = false)String size,
                             @RequestParam(value = "sfcdy",required = false)String sfcdy){

        Map map  = new HashMap<>();
        map.put("zxbm",zxbm);map.put("jgbm",jgbm);map.put("ywbm",ywbm);map.put("khbh",khbh);map.put("zhbh",zhbh);
        map.put("blqd",blqd);map.put("userid",userid);map.put("swtyhbm",swtyhbm);map.put("dysflr",dysflr);map.put("jkhtbh_begin",jkhtbh_begin);
        map.put("fxdj",fxdj);map.put("dkje_begin",dkje_begin);map.put("dkje_end",dkje_end);map.put("dknx_begin",dknx_begin);map.put("dknx_end",dknx_end);
        map.put("qzlrrq_begin",qzlrrq_begin);map.put("qzlrrq_end",qzlrrq_end);map.put("dkhkfs",dkhkfs);map.put("fwzj_end",fwzj_end);map.put("posfgjjjk",posfgjjjk);
        map.put("sfyddkh",sfyddkh);map.put("page",page);map.put("sfcdy",sfcdy);map.put("jkrzjh",jkrzjh);map.put("dkzt",dkzt);
        map.put("kfsmc",kfsmc);map.put("htrq_begin",htrq_begin);map.put("htrq_end",htrq_end);map.put("ffrq_begin",ffrq_begin);map.put("ffrq_end",ffrq_end);
        map.put("jqrq_begin",jqrq_begin);map.put("jqrq_end",jqrq_end);map.put("dwzh",dwzh);map.put("jkrdwmc",jkrdwmc);map.put("dkdblx",dkdblx);
        map.put("xmmc",xmmc);map.put("fwxz",fwxz);map.put("zfmj_begin",zfmj_begin);map.put("zfmj_end",zfmj_end);map.put("gflx",gflx);
        map.put("fwzj_begin",fwzj_begin);map.put("sfydc",sfydc);map.put("dah",dah);map.put("yqts",yqts);map.put("size",size);
        String param = JSONObject.toJSONString(map);
        logger.info("公积金接口请求个人住房贷款账户信息====方法名：getGRDKCX=======入参："+param);
        try{
            String url = "https://59.207.236.40:443/GRDKCX/grdkyw/jkrzhcx.service";
            logger.info("公积金接口请求个人住房贷款账户信息====方法名：getGRDKCX=======请求url："+url);
            String string = com.bm.https.untils.HttpsUtilsZS.getServiceNetworkInformation(param, url);
            logger.info("公积金接口请求个人住房贷款账户信息====方法名：getGRDKCX=======返回值："+string);
            return string;
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            return "error:"+param;
        }
    }


    @ApiOperation(value = "个人住房贷款业务明细信息")
    @RequestMapping(value = "/getGRDKCXxxcx",method = {RequestMethod.POST})
    public String getGRDKCXxxcx(@RequestParam(value = "jkhtbh",required = false)String jkhtbh,
                               @RequestParam(value = "jkrzjh",required = false)String jkrzjh,
                                @RequestParam(value = "sqrq_begin",required = false)String sqrq_begin,
                                @RequestParam(value = "sqrq_end",required = false)String sqrq_end){

/**
 * {"blqd":"zxb","ywbm":"%","userid":"2","zxbm":"01",
 * "jgbm":"01","page":1,"size":999,"sszh":" ",
 * "swtyhbm":" ","ywlx":"%","sqrq_begin":"1990-08-28",
 * "sqrq_end":"2222-12-28","jkrzjh":"412823199003150029","jkhtbh":""}
 */
        Map map  = new HashMap<>();
        map.put("blqd","zxb");
        map.put("ywbm","%");
        map.put("userid","2");
        map.put("zxbm","01");
        map.put("jgbm","01");
        map.put("page","1");
        map.put("size","999");
        map.put("swtyhbm"," ");
        map.put("ywlx","%");
        map.put("sqrq_begin",sqrq_begin);
        map.put("sqrq_end",sqrq_end);
        map.put("sszh"," ");
        map.put("jkrzjh",jkrzjh);
        map.put("jkhtbh","");
        String param = JSONObject.toJSONString(map);
        logger.info("公积金接口请求个人住房贷款业务明细信息====方法名：getGRDKCXxxcx=======入参："+param);
        try{
            String url = "https://59.207.236.40:443/GRDKCX/dkhkmx/xxcx.service";
            logger.info("公积金接口请求个人住房贷款业务明细信息====方法名：getGRDKCXxxcx=======请求url："+url);
            String string = com.bm.https.untils.HttpsUtilsZS.getServiceNetworkInformation(param, url);
            logger.info("公积金接口请求个人住房贷款业务明细信息====方法名：getGRDKCXxxcx=======返回值："+string);
            return string;
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            return "error:"+param;
        }
    }


    @ApiOperation(value = "个人住房贷款逾期登记信息")
    @RequestMapping(value = "/getGRDKCXcxcx",method = {RequestMethod.POST})
    public String getGRDKCXcxcx( @RequestParam(value = "yqjzrq",required = false)String yqjzrq,
                                @RequestParam(value = "ffrq_begin",required = false)String ffrq_begin,
                                @RequestParam(value = "ffrq_end",required = false)String ffrq_end,
                                @RequestParam(value = "zjhm",required = false)String zjhm){

        /**
         * {"blqd":"gt","ywbm":"0499","userid":"2","zxbm":"01",
         * "jgbm":" ","page":"1","size":"20","swtyhbm":" ",
         * "yqjzrq":"2017-08-16","ffrq_begin":"2009-07-30",
         * "ffrq_end":"2019-12-31","yqcs_begin":"1","yqcs_end":"30",
         * "ljyqcs_begin":"1","ljyqcs_end":"30","kfsbm":"","xmbh":"",
         * "yqts_begin":"1","yqts_end":"999"}
         */

        Map map  = new HashMap<>();
       /* map.put("blqd","gt");
        map.put("ywbm","0499");
        map.put("userid","2");
        map.put("zxbm","01");
        map.put("jgbm"," ");
        map.put("ffrq_end",ffrq_end);
        map.put("yqcs_end","30");
        map.put("ljyqcs_begin","1");
        map.put("ljyqcs_end","30");
        map.put("zjhm",zjhm);


        map.put("page","1");
        map.put("size","20");
        map.put("swtyhbm"," ");
        map.put("yqjzrq",yqjzrq);
        map.put("ffrq_begin",ffrq_begin);
        map.put("yqcs_begin","1");
        map.put("kfsbm","");
        map.put("xmbh","");
        map.put("yqts_begin","1");
        map.put("yqts_end","999");*/
        map.put("blqd","");
        map.put("ywbm","");
        map.put("userid","");
        map.put("zxbm","01");
        map.put("jgbm","");
        map.put("ffrq_end",ffrq_end);
        map.put("yqcs_end","");
        map.put("ljyqcs_begin","");
        map.put("ljyqcs_end","");
        map.put("zjhm",zjhm);


        map.put("page","1");
        map.put("size","999");
        map.put("swtyhbm"," ");
        map.put("yqjzrq",yqjzrq);
        map.put("ffrq_begin",ffrq_begin);
        map.put("yqcs_begin","");
        map.put("kfsbm","");
        map.put("xmbh","");
        map.put("yqts_begin","1");
        map.put("yqts_end","999");
        String param = JSONObject.toJSONString(map);
        logger.info("公积金接口请求个人住房贷款逾期登记信息====方法名：getGRDKCXcxcx1=======入参："+param);
        try{
            String url = "https://59.207.236.40:443/GRDKCX/jkryqcx/jkryqcxgrcx1.service";
            logger.info("公积金接口请求个人住房贷款逾期登记信息====方法名：getGRDKCXcxcx=======请求url："+url);
            String string = com.bm.https.untils.HttpsUtilsZS.getServiceNetworkInformation(param, url);
            logger.info("公积金接口请求个人住房贷款逾期登记信息====方法名：getGRDKCXcxcx1=======返回值："+string);
            return string;
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            return "error:"+param;
        }
    }

    @ApiOperation(value = "个人住房贷款逾期登记信息old")
    @RequestMapping(value = "/getGRDKCXcxcx1",method = {RequestMethod.POST})
    public String getGRDKCXcxcx1(@RequestParam(value = "blqd",required = false)String blqd,@RequestParam(value = "page",required = false)String page,
                                 @RequestParam(value = "ywbm",required = false)String ywbm,@RequestParam(value = "size",required = false)String size,
                                 @RequestParam(value = "userid",required = false)String userid,@RequestParam(value = "swtyhbm",required = false)String swtyhbm,
                                 @RequestParam(value = "zxbm",required = false)String zxbm,@RequestParam(value = "yqjzrq",required = false)String yqjzrq,
                                 @RequestParam(value = "jgbm",required = false)String jgbm,@RequestParam(value = "ffrq_begin",required = false)String ffrq_begin,
                                 @RequestParam(value = "ffrq_end",required = false)String ffrq_end,@RequestParam(value = "yqcs_begin",required = false)String yqcs_begin,
                                 @RequestParam(value = "yqcs_end",required = false)String yqcs_end,@RequestParam(value = "kfsbm",required = false)String kfsbm,
                                 @RequestParam(value = "ljyqcs_begin",required = false)String ljyqcs_begin,@RequestParam(value = "xmbh",required = false)String xmbh,
                                 @RequestParam(value = "ljyqcs_end",required = false)String ljyqcs_end,@RequestParam(value = "yqts_begin",required = false)String yqts_begin,
                                 @RequestParam(value = "zjhm",required = false)String zjhm,@RequestParam(value = "yqts_end",required = false)String yqts_end
    ){


        Map map  = new HashMap<>();
        map.put("blqd",blqd);
        map.put("ywbm",ywbm);
        map.put("userid",userid);
        map.put("zxbm",zxbm);
        map.put("jgbm",jgbm);
        map.put("ffrq_end",ffrq_end);
        map.put("yqcs_end",yqcs_end);
        map.put("ljyqcs_begin",ljyqcs_begin);
        map.put("ljyqcs_end",ljyqcs_end);
        map.put("zjhm",zjhm);


        map.put("page",page);
        map.put("size",size);
        map.put("swtyhbm",swtyhbm);
        map.put("yqjzrq",yqjzrq);
        map.put("ffrq_begin",ffrq_begin);
        map.put("yqcs_begin",yqcs_begin);
        map.put("kfsbm",kfsbm);
        map.put("xmbh",xmbh);
        map.put("yqts_begin",yqts_begin);
        map.put("yqts_end",yqts_end);
        String param = JSONObject.toJSONString(map);
        logger.info("公积金接口请求个人住房贷款逾期登记信息====方法名：getGRDKCXcxcx=======入参："+param);
        try{
            String url = "https://59.207.236.40:443/GRDKCX/jkryqcx/jkryqcxgrcx.service";
            logger.info("公积金接口请求个人住房贷款逾期登记信息====方法名：getGRDKCXcxcx=======请求url："+url);
            String string = com.bm.https.untils.HttpsUtilsZS.getServiceNetworkInformation(param, url);
            logger.info("公积金接口请求个人住房贷款逾期登记信息====方法名：getGRDKCXcxcx=======返回值："+string);
            return string;
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            return "error:"+param;
        }
    }
}
