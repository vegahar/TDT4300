package no.ntnu.idi.dm.arm.apriori;

import java.util.List;

public class BruteForceApriori<V> extends BaseApriori<V> {

	public BruteForceApriori(List<ItemSet<V>> transactions) {
		super(transactions);
	}

	@Override
	public void apriori(Double minSupport) {
		int k =0;
        List<ItemSet<V>> candidatesAtLevelK = getAllItemsetsOfSizeOne();

        for (int i = 2; i<candidatesAtLevelK.size(); i++){
            k++;


        }
	}

}
