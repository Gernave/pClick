public class QueryBuilder {
	private String finalQuery;

	//takes every search menu option in string form and builds query from it
	public QueryBuilder(String term, String course, String session, String filter, String x, 
						String orderBy, String order, String ignore) {
		String selectionClauses = selectionClauses(term, course, session);
		String filterQuery = filterQuery(filter, x);
		String orderByClause = orderByClause(orderBy, order);
		String ignoreClause = ignoreClauses(ignore);
		finalQuery(selectionClauses, filterQuery, orderByClause, ignoreClause);
	}
	
	public String getQuery() {
		return finalQuery;
	}
	
	private String selectionClauses(String term, String course, String session) {
		String clauses = "";
		if(term != "All") {
			// TODO add clause to string
		}
		
		if(course != "ALL") {
			// TODO add clause to string
		}
		
		if(session != "All") {
			// TODO add clause to string
		}
 		return clauses;
	}
	
	private String filterQuery(String filter, String x) {
		if (filter.equals("All")){
			// TODO return SQL string
		}
		
		if (filter.contains("correct")) {
			String sign = "";
			if (filter.contains("less")) {
				sign = "<";
			}
			if (filter.contains("more")) {
				sign = ">";
			}
			else {
				// TODO error
			}
			return correctnessQuery(sign, x);
		}
		
		else {
			// TODO error
		}
		return "";
	}
	
	private String correctnessQuery(String sign, String x) {
		// TODO add SQL
		return "blah blah" + sign + " " + x + "blah blah";
	}
	
	private String orderByClause(String orderBy, String order) {
		if(orderBy.equals("Chronological"))
			if(order.equals("Ascending")) {
				// TODO return SQL clause
			}
			if(order.equals("Descending")) {
				// TODO return SQL clause
			}
			else {
				// TODO error
			}
				
		if(orderBy.contains("correct")) {
			if(order.equals("Ascending")) {
				// TODO return SQL clause
			}
			if(order.equals("Descending")) {
				// TODO return SQL clause
			}
			else {
				// TODO error
			}
		}
		return "";
	}
	
	private String ignoreClauses(String ignore) {
		if (ignore.equals("")) { 
			return "";
		}
		// TODO
		return "";
	}

	private void finalQuery(String selectionClauses, String filterQuery, 
							String orderByClause, String ignoreClauses) {
		finalQuery = filterQuery + selectionClauses + "\n" + 
						ignoreClauses + "\n" + orderByClause;
	}
	
	
}
