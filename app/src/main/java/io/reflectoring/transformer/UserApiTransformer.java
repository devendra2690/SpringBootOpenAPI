package io.reflectoring.transformer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;

import io.reflectoring.entity.ARMAUser;
import io.reflectoring.model.Group;
import io.reflectoring.model.Result;
import io.reflectoring.model.User;
import io.reflectoring.model.UserValue;

public class UserApiTransformer {

	private static final Logger log = LoggerFactory.getLogger(UserApiTransformer.class);

	public static void transformARMAUserToUser(ARMAUser armaUser, User user) {

		log.debug("UserApiTransformer::transformARMAUserToUser::START:: starting to transform data");
		if (armaUser != null) {
			UserValue userValue = new UserValue();

			if (StringUtils.isNotBlank(armaUser.getLoginName())) {
				userValue.setLoginName(armaUser.getLoginName());
			}

			if (StringUtils.isNotBlank(armaUser.getUserNumber())) {
				userValue.setUserNumber(armaUser.getUserNumber());
			}

			if (StringUtils.isNotBlank(armaUser.getFullName())) {
				userValue.setFullName(armaUser.getFullName());
				userValue.setDisplayName(armaUser.getFullName());
				userValue.setUserName(armaUser.getFullName());
			}

			if (StringUtils.isNotBlank(String.valueOf(armaUser.getKulzanId()))) {
				userValue.setKulanzId(String.valueOf(armaUser.getKulzanId()));
			}

			if (armaUser.getMaximumApprovalAmount() != null) {
				userValue.setMaximumApprovalAmount(String.valueOf(armaUser.getMaximumApprovalAmount()));
			}
			if (armaUser.getMaximumPaymentAmount() != null) {
				userValue.setMaximumPaymentAmount(String.valueOf(armaUser.getMaximumPaymentAmount()));
			}
			if (StringUtils.isNotBlank(armaUser.getVerificatorLoginName())) {
				userValue.setVerificatorLoginName(armaUser.getVerificatorLoginName());
			}
			if (StringUtils.isNotBlank(armaUser.getVerificatorUserNumber())) {
				userValue.setVerificatorUserNumber(armaUser.getVerificatorUserNumber());
			}
			if (!CollectionUtils.isEmpty(armaUser.getGroups())) {

				List<Group> groupList = armaUser.getGroups().stream().map(group -> {
					Group groupIterObj = new Group();
					groupIterObj.setId(group.getDescription().concat("_" + group.getId()));
					return groupIterObj;
				}).collect(Collectors.toList());

				userValue.setGroups(groupList);
			}

			user.setValue(userValue);
			user.setResult(transformResultMetadata(HttpStatus.OK.name()));
		}

		log.debug("UserApiTransformer::transformARMAUserToUser::END:: Done with transformation of data");

	}

	public static Result transformResultMetadata(String statusCode) {

		log.debug("UserApiTransformer::transformResultMetadata::START:: starting to transform data");

		Result result = new Result();
		if (statusCode.equals(HttpStatus.OK.name())) {
			result.setCode("" + HttpStatus.OK.value() + "");
			result.setMetadata(Arrays.asList(HttpStatus.OK.name()));
		} else {
			result.setCode("" + HttpStatus.NOT_FOUND.value() + "");
			result.setMetadata(Arrays.asList(HttpStatus.NOT_FOUND.name()));
		}

		log.debug("UserApiTransformer::transformResultMetadata::END:: Done with transformation of data");

		return result;
	}
}
