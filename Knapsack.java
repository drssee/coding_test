/**
 * 동적계획법
 * 메모리재귀 vs 메모리for
 * 메모리for를 쓸수있으면 우선해서 쓰자
 * 이전의 결과를 기록해서, 효율적인 탐색을 하는 방법
 *
 * Knapsack
 * 풀이: 무게별 최고가치 결과 배열을 만들어
 * 물품을 순회하며 각각 최대 무게를 기록
 */
public class Knapsack {
    public static void main(String[] args) {
        System.out.println(knapsack());
    }
    static int maxWeight = 10;
    static int[] weight = {3, 4, 1, 2, 3};
    static int[] price = {2, 3, 2, 3, 6};
    //무게별 가치 기록 배열을 만든다?
    static int[] result = new int[maxWeight+1];
    static int knapsack() {
        for (int i=0; i<5; i++) {
            for (int j=0; j<result.length; j++) {
                //배낭에 물품을 하나씩 넣으면서 결과 무게 배열을 기록?
                //j==3 i의무게1 가치2
                if (result[weight[i]] == 0) result[weight[i]] = price[i];
                if ((j == weight[i] && result[j] == price[i]) || (j + weight[i]) > maxWeight) continue;
                result[j + weight[i]] = Math.max(result[j + weight[i]], result[j] + price[i]);
            }
        }
        return result[maxWeight-1];
    }
}
