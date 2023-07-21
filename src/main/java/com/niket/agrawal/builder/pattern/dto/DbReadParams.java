package com.niket.agrawal.builder.pattern.dto;

import org.apache.commons.lang3.StringUtils;

public class DbReadParams {

	private String whereClause;
	private String selectClause;
	private String orderByClause;
	private String groupByClause;

	public static class Builder {
		private String whereClause;
		private String selectClause;
		private String orderByClause;
		private String groupByClause;

		public Builder setWhereClause(String whereClause) {
			this.whereClause = whereClause;
			return this;
		}

		public Builder setSelectClause(String selectClause) {
			this.selectClause = selectClause;
			return this;
		}

		public Builder setOrderByClause(String orderByClause) {
			this.orderByClause = orderByClause;
			return this;
		}

		public Builder setGroupByClause(String groupByClause) {
			this.groupByClause = groupByClause;
			return this;
		}

		public DbReadParams build() {
			if (StringUtils.isEmpty(whereClause)) {
				throw new IllegalArgumentException("Where Clause is Mandatory");
			}
			return new DbReadParams(this);
		}
	}

	private DbReadParams(Builder builder) {
		this.whereClause = builder.whereClause;
		this.selectClause = builder.selectClause;
		this.orderByClause = builder.orderByClause;
		this.groupByClause = builder.groupByClause;
	}

	public String getWhereClause() {
		return whereClause;
	}

	public String getSelectClause() {
		return selectClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public String getGroupByClause() {
		return groupByClause;
	}

}
