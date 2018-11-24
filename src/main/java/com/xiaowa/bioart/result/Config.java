package com.xiaowa.bioart.result;


/**
 * ϵͳ���������࣬������ϵͳ�õ�����
 *
 * @author mrt
 */
public class Config {


    /**
     * ϵͳ���Ի�����Ĭ��Ϊ����zh
     */
    public static final String LANGUAGE = "zh";

    /**
     * ϵͳ���һ�����Ĭ��Ϊ�й�CN
     */
    public static final String COUNTRY = "CN";

    /**
     * servletContext
     */
    public static final String SERVLETCONTEXT_KEY = "servletContext";

    /**
     * ��ʾ��Ϣ�����ļ���
     */
    public static final String MESSAGE = "resources.messages";

    /**
     * ��ʾ��Ϣ�����ļ���
     */
    public static final String SYSTEMCONFIG = "config.config";
    /**
     * ������������
     */
    public static final String ATTACH_BELONG = "config.attach_belong";

    /**
     * ϵͳ�汾�ļ�����
     */
    public static final String VERSION = "version";

    /**
     * ����Ȩ�ޣ���Ҫ���û�����Ȩ�޼���ʹ��
     */
    public static final String COMMON_ACTIONS = "commonActions";

    /**
     * ����Ȩ�ޣ��û������¼����ʹ��
     */
    public static final String ANONYMOUS_ACTIONS = "anonymousActions";

    /**
     * ϵͳ���������ļ�����
     */
    public static final String SYSCONFIG = "sysParams";

    /**
     * session�д�ŵ�¼�û���key����
     */
    public static final String ACTIVEUSER_KEY = "activeUser";

    /**
     * �����ļ���ϵͳ����url��key����
     */
    public static final String BASEURL_KEY = "baseurl";

    /**
     * �����ļ���ϵͳ����url��key����
     */
    public static final String SYSMANAGERURL_KEY = "sysmanagerurl";

    /**
     * �����ļ���ϵͳ����url��key����
     */
    public static final String SYSCONFIGURL_KEY = "sysconfigurl";

    /**
     * �����ļ��м�����Կ��key����
     */
    public static final String DESKEY_KEY = "deskey";

    /**
     * ϵͳ����ϵͳ����ƽ̨����key����
     */
    public static final String LOGINKEY = "loginkeyString";

    /**
     * �����ļ���ϵͳ�汾���Ƶ�key����
     */
    public static final String VERSION_NAME_KEY = "version_name";

    /**
     * �����ļ���ϵͳ�汾�ŵ�key����
     */
    public static final String VERSION_NUMBER_KEY = "version_number";

    /**
     * �����ļ���ϵͳ�汾����ʱ���key����
     */
    public static final String VERSION_DATE_KEY = "version_date";

    /**
     * ϵͳ��ʾ��ϢResultInfo����key
     */
    public static final String RESULTINFO_KEY = "resultInfo";


    /**
     * ����ģ����ҳ��·�� ����/WEB-INF/jsp��
     */
    public static final String PAGE_PATH_BASE = "/base";

    /**
     * ҵ��ģ����ҳ��·�� ����/WEB-INF/jsp��
     */
    public static final String PAGE_PATH_BUSINESS = "/business";


    /**
     * һ�������ʾҳ��,��·����Ҫƥ��ҳ��ǰ��׺
     */
    public static final String ERROR_PAGE = "/base/error";
    /**
     * ��¼ҳ���ַ,��·����Ҫƥ��ҳ��ǰ��׺
     */
    public static final String LOGIN_PAGE = "/base/login";

    /**
     * ��Ȩ��ʾҳ���ַ,��·����Ҫƥ��ҳ��ǰ��׺
     */
    public static final String REFUSE_PAGE = "/base/refuse";

    /**
     * ϵͳ����action�������¼����ʹ��
     */
    //private static List<Operation> anonymousActions;


    /**
     * ��ȡ�������ʵ�ַ
     * @return
     */
	/*public static List<Operation> getAnonymousActions() {
		if(anonymousActions !=null){
			return anonymousActions;
		}
		anonymousActions = new ArrayList<Operation>();

		List<String> baseActions_list = ResourcesUtil.gekeyList(Config.ANONYMOUS_ACTIONS);
		for (String common_actionUrl:baseActions_list) {
			Operation o_i = new Operation(common_actionUrl);
			anonymousActions.add(o_i);
		}
		return anonymousActions;
	}
*/


}
