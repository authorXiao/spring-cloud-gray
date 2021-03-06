package cn.springcloud.gray.local;

import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public abstract class LazyInstanceLocalInfoInitiralizer implements InstanceLocalInfoInitiralizer, ApplicationContextAware {

    protected ApplicationContext applicationContext;
    protected InstanceLocalInfo instanceLocalInfo;


    @Override
    public InstanceLocalInfo getInstanceLocalInfo() {
        if(instanceLocalInfo==null){
            instanceLocalInfo = createInstanceLocalInfo();
        }
        return instanceLocalInfo;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    protected InstanceLocalInfo createInstanceLocalInfo() {
        Registration registration = applicationContext.getBean(Registration.class);
        return InstanceLocalInfo.builder()
                .instanceId(getLocalInstanceId())
                .serviceId(registration.getServiceId())
                .host(registration.getHost())
                .port(registration.getPort())
                .build();
    }

    protected abstract String getLocalInstanceId();

}
