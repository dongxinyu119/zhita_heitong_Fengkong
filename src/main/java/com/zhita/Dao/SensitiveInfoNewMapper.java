package com.zhita.Dao;

import org.apache.ibatis.annotations.Param;

import com.zhita.Model.SensitiveInfoNew;

public interface SensitiveInfoNewMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SensitiveInfoNew record);

    int insertSelective(SensitiveInfoNew record);

    SensitiveInfoNew selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SensitiveInfoNew record);

    int updateByPrimaryKey(SensitiveInfoNew record);

	void setsensitiveInfoNew(@Param("userId")int userId,@Param("key_information_risk_level") String key_information_risk_level,
			@Param("key_information_item_id")int key_information_item_id,@Param("key_information_item_name") String key_information_item_name,
			@Param("key_information_check_result")String key_information_check_result,
			@Param("key_information_idcard_matching")String key_information_idcard_matching,
			@Param("key_information_name_matching")String key_information_name_matching,@Param("net_time_risk_level") String net_time_risk_level,
			@Param("net_time_item_id")int net_time_item_id,@Param("net_time_item_name") String net_time_item_name,
			@Param("net_time_check_result")String net_time_check_result,@Param("network_length_check") String network_length_check,
			@Param("applicant_blacklist_risk_level")String applicant_blacklist_risk_level,
			@Param("applicant_blacklist_item_id")int applicant_blacklist_item_id,
			@Param("applicant_blacklist_item_name")String applicant_blacklist_item_name,
			@Param("applicant_blacklist_check_result")String applicant_blacklist_check_result,
			@Param("applicant_blacklist_idcard")String applicant_blacklist_idcard,
			@Param("applicant_blacklist_phone_number")String applicant_blacklist_phone_number,
			@Param("emergency_blacklist_blacklist_risk_level")String emergency_blacklist_blacklist_risk_level,
			@Param("emergency_blacklist_blacklist_item_id")int emergency_blacklist_blacklist_item_id,
			@Param("emergency_blacklist_blacklist_item_name")String emergency_blacklist_blacklist_item_name,
			@Param("emergency_blacklist_check_result")String emergency_blacklist_check_result,
			@Param("blacklist_communication_blacklist_risk_level")String blacklist_communication_blacklist_risk_level,
			@Param("blacklist_communication_blacklist_item_id")int blacklist_communication_blacklist_item_id,
			@Param("blacklist_communication_blacklist_item_name")String blacklist_communication_blacklist_item_name,
			@Param("blacklist_communication_check_result")String blacklist_communication_check_result,
			@Param("id_card_blacklist_risk_level")String id_card_blacklist_risk_level,@Param("id_card_blacklist_item_id") int id_card_blacklist_item_id,
			@Param("id_card_blacklist_item_name")String id_card_blacklist_item_name,@Param("id_card_check_result") String id_card_check_result,
			@Param("result")String result,@Param("private_lending_risk_level") String private_lending_risk_level,
			@Param("private_lending_item_id")int private_lending_item_id,@Param("private_lending_item_name") String private_lending_item_name,
			@Param("private_lending_check_result")String private_lending_check_result,
			@Param("financial_institutions_risk_level")String financial_institutions_risk_level,
			@Param("financial_institutions_item_id")int financial_institutions_item_id,
			@Param("financial_institutions_item_name")String financial_institutions_item_name,
			@Param("financial_institutions_check_result")String financial_institutions_check_result,
			@Param("credit_card_risk_level")String credit_card_risk_level,@Param("credit_card_item_id") int credit_card_item_id,
			@Param("credit_card_item_name")String credit_card_item_name,@Param("credit_card_check_result") String credit_card_check_result,
			@Param("lending_platform_risk_level")String lending_platform_risk_level,@Param("lending_platform_item_id") int lending_platform_item_id,
			@Param("lending_platform_item_name")String lending_platform_item_name,
			@Param("lending_platform_check_result")String lending_platform_check_result,
			@Param("internet_loan_risk_level")String internet_loan_risk_level,@Param("internet_loan_item_id") int internet_loan_item_id,
			@Param("internet_loan_item_name")String internet_loan_item_name,@Param("internet_loan_check_result") String internet_loan_check_result,
			@Param("court_risk_level")String court_risk_level,@Param("court_item_id") int court_item_id,@Param("court_item_name") String court_item_name,
			@Param("court_check_result")String court_check_result,@Param("risk_level_110") String risk_level_110,@Param("item_id_110") int item_id_110,
			@Param("item_name_110")String item_name_110,@Param("check_result_110") String check_result_110,
			@Param("lawyer_risk_level")String lawyer_risk_level,@Param("lawyer_item_id") int lawyer_item_id,
			@Param("lawyer_item_name")String lawyer_item_name,@Param("lawyer_check_result") String lawyer_check_result,
			@Param("risk_level_120")String risk_level_120,@Param("item_id_120") int item_id_120,@Param("item_name_120") String item_name_120,
			@Param("check_result_120")String check_result_120,@Param("macao_communication_risk_level") String macao_communication_risk_level,
			@Param("macao_communication_item_id")int macao_communication_item_id,
			@Param("macao_communication_item_name")String macao_communication_item_name,
			@Param("macao_communication_check_result")String macao_communication_check_result);
}