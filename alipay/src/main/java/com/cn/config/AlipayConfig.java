package com.cn.config;

public class AlipayConfig {
        // 商户的私钥,使用支付宝自带的openssl工具生成。
        public static String private_key="MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCXWiNK7mRwTGP2NlPw8VrnV8gonqz6enxkzNbQtkCtfgMdpLWGTV0EuZ80WoWbiOqjIFcIALk6ZRr2u5KMCxoTtZ/CZRuOEnUzjtsCLbl/XsJ23iKijrG0ROqbmshqAgG7Ul+AkClDDxL9zcAhDq1yB9ALc1cKJDVbm+qqkE1Jl8zVocfnbdzbMKTg/3pmVLpuVaF16gvC4IcsSPbNmTPRDoFPAIQkD47S3T7L7QZph46vkQxwsq9coMpyfljoGJklORK6Lotaarv+yf1PxUnwXX6DTEKeTfY+IfJsuqP9jg++0SlJC4cCMTkHVqCaRGt8Uu9VAYIE1AwJeCwTjgtjAgMBAAECggEAURX6iH91kfBrMZJjoFc+E2klFBYGqF8M29geUk0CE7DKLIx8sAoshoaH8713jR9qTaDa36+7jLx0GLHfTmX4P4zznWsbux7KaafkT6N9mO6Ekrhpp9t4+xJc+qaPLrQKh3gXMEKLyKB/1Tfw8gTyCYCEBk5x2D4T1BORQnXy4jS8Kb6+9rT5E1ENrNyCwZlxttXRzp6TawJZE8jkvUf9A7ouqhsBMHjr/N6wLpgkMX4EmtNZiR/nvGiZn5IcsalmRtFxTQ27DF/BVe5tn79j1Z6dalrVq5s6/jGyroEMiDquKqo85g8b/aLlT55Zb1PqgYlaViUZSfdcOwXdiapwsQKBgQDdZ83o/y6Q7g2ZbjPfpNmNHogTmwyEyFvAgLih6fCY+lk4z2PX+i+ttXOcSCiiyh4STj7Ah/jYI8zj7KffL8KSS8Su4Y6RiuvHmrllodOrgo+bSsQu4DAkiCyNcjoqeXuxG9escCyzyPGDouSvGbvJakU8MYxH5vq1EmHDM+d9ywKBgQCvADSmAPFgpUvPRmuCgSvxEBTi3AHb3YX+OHc5bBXlrz827LgodbdlPVQTEPrihVDA51VXcpHG27tSXXnRREZOtaR7TjdvNGvvIuBSKgvtrS7cGtjvmN3dMPZ1uY+6PqxExbimiwtjaIDzRMoSPePTKnj/V5RKn5GQZvSEKRv1yQKBgQC8I5tb5IwjZ8ZynKzD3IdpXYpwbo7CvqcI+9jo7awfsozis4i6XMTrLYeiQ8cUHgBTud2lKWYR9MoE3HMCOslyG6R0nwLRNmWI5jeo30zJL1bstSnkU2lVgcmqIGjA8x5ir7Ajveael6BzJZaCHLHwQ7e1oLz91I8yEv60K4UI5QKBgQCuUTUgWnYVv/Fo0YuL3qFnqY40f9Q2L04mchaIk1qohM0iJ+A1JTT+Wn2h1FskQomy7Xv79HqzK/NG0yfhxPGHu7XQwZPEaOJOvV3XWlyxbr3rr66B07LEft4xXBqH+Z/djVomQwCgD9vK9q2WSCHlGTyXlKR5RMNZpMRR1SUtyQKBgQCG9vc9wP9QYkzQBAM2lqZil8gYiW5F2jEQTLy0EHLGRw24y0GaH9zLTKX7x+1X5XZTPJ7GOzILbw4Uzdr4Dwwr3n5c+L7qm51JvbvB6Uepy2nr435gBlmXANKaqw52NWOJNLUKPhoSSX+As2IasknK50OOri+c8VwCohdjLevOXg==";
        // 支付宝的公钥，
        public static String ali_public_key  = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhtsgIeeQg50bBenTZ2CNAohzrBO77m8ern5UGtAgHXVRi49W4PbL/gvdb7qLeznXCFhaFnidPIBnHF9MPhfq19QqYNregCBIJ7RehmoL93xjJQoYfAQ314I4n1D3lCACbtrlhtE/M2kKM1LPL3ZyYEjk11rqtD6ZFsuA2SrbKts1iH1fH9wjKdJOFOWWBwwe0oOws5HaqEr8jRqcGXjDcJJ6VR/LXBbvePCcnkPV02tNnjLTClxwrbxXJsO1w88D0Mg7YICQJLpTfIT0/iTrCcurubgEJUGbxkh8AT3CoqcCD2PaH+tkAccxtDodBUdXAYd8iVgcHxMr+IkD1dzc6wIDAQAB";
        // 接收通知的接口名(这里的域名或者ip需要填写外网可以访问的地址)
        public static String service = "https://www.dq-city.com/aliPay/api/callBack";
        //APPID
        public static String app_id="2018121462559391";
}