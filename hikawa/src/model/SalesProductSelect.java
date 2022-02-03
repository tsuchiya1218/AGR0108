package model;

public class SalesProductSelect {
		private String PdCode; //商品コード
		private String PdName; //商品名

		public SalesProductSelect() {
		}

		public SalesProductSelect(String PdCode, String PdName) {
			this.PdCode = PdCode;
			this.PdName = PdName;
		}

		public void setPdCode(String PdCode) {
			this.PdCode = PdCode;
		}

		public String getPdCode() {
			return PdCode;
		}

		public void setPdName(String PdName) {
			this.PdName = PdName;
		}

		public String getPdName() {
			return PdName;
		}
}
