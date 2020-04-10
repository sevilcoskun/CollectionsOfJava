
package main.maps;

import java.util.Objects;

    public class ProductMap {
        private final int id;
        private final String name;
        private final int weight;

        public ProductMap(int id, String name, int weight) {
            this.id = id;
            this.name = name;
            this.weight = weight;
        }

        public int getId() { return id; }

        public String getName() { return name; }

        public int getWeight() { return weight; }


        @Override
        public String toString() {
            return "ProductMap{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ProductMap that = (ProductMap) o;
            return id == that.id &&
                    weight == that.weight &&
                    Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, weight);
        }
    }
