package site.lovecode.wechat.client;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WechatFactory {


	private final Logger logger = LoggerFactory.getLogger(WechatFactory.class);


	/*public WechatClient getInstance( Long officialAccountId ) {
		WechatConfig wechatConfig = JSON.parseObject(redisCache.getValue(officialAccountId), WechatConfig.class);
		if ( wechatConfig.getAccountType().equals(OfficialAccountTypeEnum.AUTHORIZATION.key()) ) {
			wechatAuthorizationClient.setWxMpConfigStorage(wechatConfig);
			return wechatAuthorizationClient;
		} else {
			wechatBindClient.setWxMpConfigStorage(wechatConfig);
			return wechatBindClient;
		}
	}
*/
}
