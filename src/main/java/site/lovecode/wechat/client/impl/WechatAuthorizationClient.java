package site.lovecode.wechat.client.impl;


import me.chanjar.weixin.common.exception.WxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.lovecode.wechat.client.WechatThirdPartyClient;
import site.lovecode.wechat.support.bean.AuthorizerTokenBean;
import site.lovecode.wechat.support.config.WechatConfig;

import javax.annotation.Resource;


/**
 * Created by Administrator on 2016/3/30.
 */

public class WechatAuthorizationClient extends WechatClientImpl {

	private final Logger logger = LoggerFactory.getLogger(WechatAuthorizationClient.class);

	@Resource
	private WechatThirdPartyClient wechatThirdPartyClient;



	@Override
	public String getAccessToken( boolean forceRefresh ) throws WxErrorException {
		if ( forceRefresh ) {
			wxMpConfigStorage.expireAccessToken();
		}
		if ( wxMpConfigStorage.isAccessTokenExpired() ) {
			synchronized ( globalAccessTokenRefreshLock ) {
				if ( wxMpConfigStorage.isAccessTokenExpired() ) {
					WechatConfig wechatConfig = (WechatConfig) wxMpConfigStorage;
					AuthorizerTokenBean authorizerTokenBean = wechatThirdPartyClient.refreshAuthorizerToken(
						wechatConfig.getAppId(), wechatConfig.getRefreshToken());
					wxMpConfigStorage.updateAccessToken(
						authorizerTokenBean.getAuthorizerAccessToken(), authorizerTokenBean.getExpiresIn());

				}
			}
		}
		return wxMpConfigStorage.getAccessToken();
	}
}
