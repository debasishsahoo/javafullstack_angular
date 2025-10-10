package PackagePrivateAccess;

//slightly more visibility than private but less than protected or public
//not 100% Encapsulate

//Encapsulation aims to:
//Hide data (data hiding)90%
//Control access via methods
//Using default access can partially encapsulate your data — it restricts access outside the package,
//but allows access to other classes in the same package.

//useful
//group related classes in a package
//Allow internal communication between them
//While blocking external code from other packages


//Problem
//Default access does not fully encapsulate data like private does
//Other classes in the same package can still modify the data directly.
//Hence, for strong encapsulation, private + getters/setters is preferred.


public class PackageClass {
	// No modifier = package-private
	int packageVariable;
	void packageMethod() {
		// Accessible within the same package
	}
}
