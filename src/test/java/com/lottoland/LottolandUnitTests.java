package com.lottoland;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEquals;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCode;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToString;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.lottoland.dto.ErrorDTO;
import com.lottoland.dto.GlobalStatsJankenDTO;
import com.lottoland.dto.JankenDTO;
import com.lottoland.dto.StatsJankenDTO;
import com.lottoland.entity.JankenEntity;

@RunWith(SpringRunner.class)
public class LottolandUnitTests {

	@Test
    public void testJankenDTO() {
        assertThat(JankenDTO.class, allOf(
                hasValidBeanConstructor(),
                hasValidGettersAndSetters(),
                hasValidBeanHashCode(),
                hasValidBeanEquals(),
                hasValidBeanToString()
        ));
    }
	
	@Test
    public void testStatsJankenDTO() {
        assertThat(StatsJankenDTO.class, allOf(
                hasValidBeanConstructor(),
                hasValidGettersAndSetters(),
                hasValidBeanHashCode(),
                hasValidBeanEquals(),
                hasValidBeanToString()
        ));
    }
	
	@Test
    public void testGlobalStatsJankenDTO() {
        assertThat(GlobalStatsJankenDTO.class, allOf(
                hasValidBeanConstructor(),
                hasValidGettersAndSetters(),
                hasValidBeanHashCode(),
                hasValidBeanEquals(),
                hasValidBeanToString()
        ));
    }
	
	@Test
    public void testErrorDTO() {
        assertThat(ErrorDTO.class, allOf(
                hasValidBeanConstructor(),
                hasValidGettersAndSetters(),
                hasValidBeanHashCode(),
                hasValidBeanEquals(),
                hasValidBeanToString()
        ));
    }
	
	@Test
    public void testJankenEntity() {		
        assertThat(JankenEntity.class, allOf(
                hasValidBeanConstructor(),
                hasValidGettersAndSetters(),
                hasValidBeanHashCode(),
                hasValidBeanEquals(),
                hasValidBeanToString()
        ));
    }
}
