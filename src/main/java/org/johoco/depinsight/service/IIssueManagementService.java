package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.IssueManagement;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface IIssueManagementService {

//	IssueManagement getByKey(final IssueManagementKey key) throws Exception;

	IssueManagement save(final IssueManagement issueManagement);

}
